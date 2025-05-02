package com.meli.api_futebol.service.partida;

import com.meli.api_futebol.dto.create.ClubePartidaRequestDTO;
import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.Partida;
import com.meli.api_futebol.repository.ClubeRepository;
import com.meli.api_futebol.repository.EstadioRepository;
import com.meli.api_futebol.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class PartidaEdicaoServiceImpl implements iPartidaEdicaoService{

    private final PartidaRepository partidaRepository;
    private final ClubeRepository clubeRepository;
    private final EstadioRepository estadioRepository;

    @Override
    public Partida atualizarGols(Long id, PartidaRequestDTO partidaRequestDTO) {
        Partida partidaExistente = partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada."));

        if (partidaRequestDTO.getClubeParticipantes() != null) {
            partidaRequestDTO.getClubeParticipantes().forEach(cpDTO -> {
                if (cpDTO.getGols() < 0) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O número de gols não pode ser negativo.");
                }
            });
        }
        log.info("Atualizando os gols da partida de Id {}", id);
        return partidaRepository.save(partidaExistente);
    }

    @Override
    public Partida atualizarClubes(Long id, PartidaRequestDTO partidaRequestDTO) {
        Partida partidaExistente = partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada."));

        Set<Long> clubesIds = new HashSet<>();
        for (ClubePartidaRequestDTO clubePartidaRequestDTO : partidaRequestDTO.getClubeParticipantes()) {
            if (clubesIds.contains(clubePartidaRequestDTO.getClubeId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O mesmo clube não pode participar mais de uma vez.");
            }
            clubesIds.add(clubePartidaRequestDTO.getClubeId());
        }

        for (ClubePartida clubePartida : partidaExistente.getClubesParticipates()){
            Clube clube = clubePartida.getClube();
            if (!clube.isStatusAtividade()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é permitido inserir clube inativo.");
            }
        }

        partidaRequestDTO.getClubeParticipantes().forEach(cpDTO -> {
            clubeRepository.findById(cpDTO.getClubeId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Clube não encontrado."));
        });
        log.info("Atualizando os clubes da partida de ID {}", id);
        return partidaRepository.save(partidaExistente);
    }

    /*
    @Override
    public Partida atualizarDataHora(Long id, PartidaRequestDTO partidaRequestDTO) {
        Partida partidaExistente = partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada."));

        if (partidaRequestDTO == null || partidaRequestDTO.getDataHora() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data e hora são obrigatórios para atualização.");
        }

        LocalDateTime novaData = partidaRequestDTO.getDataHora();


        for (ClubePartida clubePartida : partidaExistente.getClubesParticipates()) {
            Clube clube = clubePartida.getClube();
            if (novaData.isBefore(clube.getDataCriacao())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "A data da partida não pode ser anterior à data de criação do clube " + clube.getId()
                );
            }
        }

        // Validar conflito de estádio no mesmodia
        LocalDateTime inicioDoDia = novaData.minusHours(48);
        LocalDateTime fimDoDia = novaData.plusHours(48);

        List<Partida> partidasNoEstadio = estadioRepository.findAllByPartidaDataHoraBetweenAndIdNotNull(
                partidaExistente.getEstadio().getId(),
                inicioDoDia,
                fimDoDia
        );

        if (!partidasNoEstadio.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este estádio já possui uma partida agendada para este dia.");
        }

        // Validar 48 horas
        for (ClubePartida clubePartida : partidaExistente.getClubesParticipates()) {
            Clube clube = clubePartida.getClube();
            LocalDateTime inicioProtecao = novaData.minusHours(48);
            LocalDateTime fimProtecao = novaData.plusHours(48);

            List<Partida> partidasRecentes = partidaRepository.findAllByDataHoraBetweenAndClubesParticipantesClube_idNotNull(inicioProtecao, fimProtecao, clube.getId());

            if (!partidasRecentes.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "O clube " + clube.getId() + " já possui uma partida agendada dentro do período de 48 horas."
                );
            }
        }


        if (novaData.isAfter(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A data da partida não pode ser no futuro.");
        }

        partidaExistente.setDataHora(novaData);

        log.info("Atualizando data da partida com ID {}: {}", id, novaData);
        return partidaRepository.save(partidaExistente);
    }
     */

    @Override
    public Partida atualizarEstadio(Long id, PartidaRequestDTO partidaRequestDTO) {
        Partida partidaExistente = partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada."));

        estadioRepository.findById(partidaRequestDTO.getEstadioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estádio não encontrado."));

        log.info("Atualizando estádio da partida de ID {}", id);
        return partidaRepository.save(partidaExistente);
    }

}









