package com.meli.api_futebol.dto.criacao.mapper;

import com.meli.api_futebol.dto.criacao.ClubePartidaRequestDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.Partida;
import jakarta.servlet.http.Part;

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
