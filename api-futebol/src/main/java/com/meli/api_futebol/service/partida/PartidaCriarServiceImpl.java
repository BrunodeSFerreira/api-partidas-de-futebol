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

import java.util.ArrayList;
import java.util.List;

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

    public Partida criarPartida(PartidaRequestDTO request) {

        if (request.getClubeParticipantes() == null || request.getClubeParticipantes().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhum clube participante foi informado.");
        }

        Estadio estadio = estadioRepository.findById(request.getEstadioId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Estádio não encontrado."));


        Partida partida = new Partida();
        partida.setDataHora(request.getDataHora());
        estadio.setId(request.getEstadioId());
        partida.setEstadio(estadio);

        List<ClubePartida> clubesParticipantes = new ArrayList<>();
        for (ClubePartidaRequestDTO cpDTO : request.getClubeParticipantes()) {
            Clube clube = clubeRepository.findById(cpDTO.getClubeId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado com ID: " + cpDTO.getClubeId()));

            ClubePartida clubePartida = new ClubePartida();
            clubePartida.setClube(clube);
            clubePartida.setPartida(partida);
            clubePartida.setGols(cpDTO.getGols());
            clubePartida.setMandante(cpDTO.isMandante());

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

}