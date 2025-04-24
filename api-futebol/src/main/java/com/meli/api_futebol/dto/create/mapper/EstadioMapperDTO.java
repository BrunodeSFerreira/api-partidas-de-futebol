package com.meli.api_futebol.dto.create.mapper;

import com.meli.api_futebol.dto.create.EstadioRequestDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.model.Partida;

import java.util.List;
import java.util.stream.Collectors;

public class EstadioMapperDTO {

    public static Estadio toEntity(EstadioRequestDTO dto) {
        Estadio estadio = new Estadio();
        estadio.setNomeEstadio(dto.getNomeEstadio());

        List<Partida> partidasDTO = estadio.getPartidas().stream().map(partidas -> {
            Partida partida = new Partida();
            partida.setDataHora(partidas.getDataHora());
            partida.setEstadio(partidas.getEstadio());
            partida.setClubesParticipates(partidas.getClubesParticipates());
            return partida;
        }).collect(Collectors.toList());
        estadio.setPartidas(partidasDTO);
        return estadio;
    }

}
