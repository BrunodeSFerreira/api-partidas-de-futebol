package com.meli.api_futebol.dto.criacao.mapper;
import com.meli.api_futebol.dto.criacao.ClubeRequestDTO;
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
        clube.setStatusAtividade(dto.isStatusAtividade());

        List<ClubePartida> partidaDTO = clube.getClubePartidas().stream().map(cp -> {
            ClubePartida clubePartida = new ClubePartida();
            clubePartida.setId(cp.getId());
            clubePartida.setClube(cp.getClube());
            clubePartida.setPartida(cp.getPartida());
            clubePartida.setGols(cp.getGols());
            clubePartida.setMandante(cp.isMandante());
            return clubePartida;
        }).collect(Collectors.toList());

        clube.setClubePartidas(partidaDTO);

        return clube;
    }


}
