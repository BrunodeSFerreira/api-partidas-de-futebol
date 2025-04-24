package com.meli.api_futebol.dto.create.mapper;

import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.model.Partida;

import java.util.List;
import java.util.stream.Collectors;

public class PartidaMapperDTO {

    public static Partida toEntity(PartidaRequestDTO dto, Estadio estadio) {

        Partida partida = new Partida();
        partida.setDataHora(dto.getDataHora());
        partida.setEstadio(estadio);


        List<ClubePartida> partidaDTO = partida.getClubesParticipates().stream().map(cp -> {
            ClubePartida clubePartida = new ClubePartida();
            clubePartida.setId(cp.getId());
            clubePartida.setClube(cp.getClube());
            clubePartida.setPartida(cp.getPartida());
            clubePartida.setGols(cp.getGols());
            clubePartida.setMandante(cp.isMandante());
            return clubePartida;
        }).collect(Collectors.toList());

        partida.setClubesParticipates(partidaDTO);
        return partida;
    }

}
