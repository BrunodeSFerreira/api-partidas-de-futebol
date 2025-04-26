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

        return estadio;
    }

    public static Estadio toEntity(Long id, EstadioRequestDTO dto) {
        Estadio estadio = new Estadio();
        estadio.setId(id);
        estadio.setNomeEstadio(dto.getNomeEstadio());
        return estadio;
    }

}
