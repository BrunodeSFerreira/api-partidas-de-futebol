package com.meli.api_futebol.dto.create.mapper;

import com.meli.api_futebol.dto.create.ClubePartidaRequestDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.Partida;

public class ClubePartidaMapperDTO {

    public static ClubePartida toEntity(ClubePartidaRequestDTO dto, Clube clube, Partida partida) {
        ClubePartida clubePartida = new ClubePartida();
        clubePartida.setClube(clube);
        clubePartida.setPartida(partida);
        clubePartida.setGols(dto.getGols());
        clubePartida.setMandante(dto.isMandante());
        return clubePartida;
    }

}
