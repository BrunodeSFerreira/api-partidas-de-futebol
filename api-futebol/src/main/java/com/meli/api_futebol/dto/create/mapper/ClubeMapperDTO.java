package com.meli.api_futebol.dto.create.mapper;
import com.meli.api_futebol.dto.create.ClubeRequestDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;

import java.util.List;
import java.util.stream.Collectors;

public class ClubeMapperDTO {

    public static Clube toEntity(ClubeRequestDTO dto) {

        Clube clube = new Clube();
        clube.setNomeClube(dto.getNomeClube());
        clube.setEstadosBrasileiros(dto.getEstadosBrasileiros());
        clube.setDataCriacao(dto.getDataCriacao());

        return clube;
    }

    public static Clube toEntity(Long id, ClubeRequestDTO dto) {

        Clube clube = new Clube();
        clube.setNomeClube(dto.getNomeClube());
        clube.setEstadosBrasileiros(dto.getEstadosBrasileiros());
        clube.setDataCriacao(dto.getDataCriacao());

        return clube;
    }

}
