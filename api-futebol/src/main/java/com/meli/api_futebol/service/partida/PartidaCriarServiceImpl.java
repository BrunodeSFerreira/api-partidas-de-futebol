package com.meli.api_futebol.service.partida;

import com.meli.api_futebol.dto.create.ClubePartidaRequestDTO;
import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.model.Partida;
import com.meli.api_futebol.repository.ClubePartidaRepository;
import com.meli.api_futebol.repository.ClubeRepository;
import com.meli.api_futebol.repository.EstadioRepository;
import com.meli.api_futebol.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PartidaCriarServiceImpl implements iPartidaCriarService {

    private final PartidaRepository partidaRepository;
    private final EstadioRepository estadioRepository;
    private final ClubeRepository clubeRepository;
    private final ClubePartidaRepository clubePartidaRepository;

    @Override
    public Partida criarPartida(PartidaRequestDTO partidaRequestDTO) {

        verificarDataHoraValida( partidaRequestDTO);

        verificarQuePossuiClubeNaPartida(partidaRequestDTO);

        verificarSeEstadioPossuiPartidaParaMesmoDia(partidaRequestDTO);

        verificarQueGolsNaoPodemSerNegativos(partidaRequestDTO);

        verificarQueClubeNaoPodeParticiparDuasVezesDaMesmaPartida(partidaRequestDTO);

        Estadio estadio = estadioRepository.findById(partidaRequestDTO.getEstadioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estádio não encontrado."));

        Partida partida = new Partida();
        partida.setDataHora(partidaRequestDTO.getDataHora());
        estadio.setId(partidaRequestDTO.getEstadioId());
        partida.setEstadio(estadio);

        List<ClubePartida> clubesParticipantes = new ArrayList<>();
        for (ClubePartidaRequestDTO clubePartidaRequestDTO : partidaRequestDTO.getClubeParticipantes()) {
            Clube clube = clubeRepository.findById(clubePartidaRequestDTO.getClubeId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Clube não encontrado com ID: " + clubePartidaRequestDTO.getClubeId()));

            if(partidaRequestDTO.getDataHora().isBefore(clube.getDataCriacao())){
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "A data da partida não pode ser anterior à data da criação do Clube.");
            }

            if (!clube.isStatusAtividade()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível realizar uma partida com um dos clubes inativo");
            }

            ClubePartida clubePartida = new ClubePartida();
            clubePartida.setClube(clube);
            clubePartida.setPartida(partida);
            clubePartida.setGols(clubePartidaRequestDTO.getGols());
            clubePartida.setMandante(clubePartidaRequestDTO.isMandante());
            clubesParticipantes.add(clubePartida);
        }

        Partida partidaSalva = partidaRepository.save(partida);

        for (ClubePartida clubePartida : clubesParticipantes) {
            clubePartida.setPartida(partidaSalva);
        }

        clubePartidaRepository.saveAll(clubesParticipantes);
        partidaSalva.setClubesParticipates(clubesParticipantes);
        return partidaRepository.save(partidaSalva);
    }

    private void verificarQueClubeNaoPodeParticiparDuasVezesDaMesmaPartida(PartidaRequestDTO partidaRequestDTO) {
        Set<Long> clubesIds = new HashSet<>();
        for (ClubePartidaRequestDTO clubePartidaRequestDTO : partidaRequestDTO.getClubeParticipantes()) {
            if (clubesIds.contains(clubePartidaRequestDTO.getClubeId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "O mesmo clube não pode participar mais de uma vez na mesma partida.");
            }
            clubesIds.add(clubePartidaRequestDTO.getClubeId());
        }

    }
    private void verificarDataHoraValida(PartidaRequestDTO partidaRequestDTO) {
        if (partidaRequestDTO.getDataHora() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário informar data e hora.");
        } else if (partidaRequestDTO.getDataHora().isAfter(LocalDateTime.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data da partida não pode ser posterior à data atual.");
        }
    }
    private void verificarQuePossuiClubeNaPartida(PartidaRequestDTO partidaRequestDTO) {
        if (partidaRequestDTO.getClubeParticipantes() == null || partidaRequestDTO.getClubeParticipantes().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhum clube participante foi informado.");
        }
    }

    private void verificarQueGolsNaoPodemSerNegativos(PartidaRequestDTO partidaRequestDTO){
        for (ClubePartidaRequestDTO clubePartidaRequestDTO : partidaRequestDTO.getClubeParticipantes()) {
            if (clubePartidaRequestDTO.getGols() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor dos gols não pode ser negativo.");
            }
        }
    }

    private LocalDateTime getInicioDoDia(LocalDateTime dataHora) {
        return dataHora.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    private LocalDateTime getFimDoDia(LocalDateTime dataHora) {
        return dataHora.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    private void verificarSeEstadioPossuiPartidaParaMesmoDia(PartidaRequestDTO partidaRequestDTO) {
        LocalDateTime dataHora = partidaRequestDTO.getDataHora();
        LocalDateTime inicioDoDia = getInicioDoDia(dataHora);
        LocalDateTime fimDoDia = getFimDoDia(dataHora);

        List<Partida> partidasNoEstadioNoMesmoDia = partidaRepository
                .findAllByEstadioIdAndDataHoraBetween(
                        partidaRequestDTO.getEstadioId(),
                        inicioDoDia,
                        fimDoDia
                );

        if (!partidasNoEstadioNoMesmoDia.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Já existe uma partida agendada para este estádio nesta data."
            );
        }
    }

}