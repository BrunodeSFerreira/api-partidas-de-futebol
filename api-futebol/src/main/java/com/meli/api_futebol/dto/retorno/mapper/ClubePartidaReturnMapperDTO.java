package com.meli.api_futebol.dto.retorno.mapper;

import com.meli.api_futebol.dto.retorno.ClubePartidaReturnDTO;
import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;
import com.meli.api_futebol.model.ClubePartida;

public class ClubePartidaReturnMapperDTO {

    public static ClubePartidaReturnDTO entityToDTO(ClubePartida clubePartida) {
        ClubePartidaReturnDTO clubePartidaReturnDTO = new ClubePartidaReturnDTO();

        clubePartidaReturnDTO.setClubeId(clubePartida.getClubeId());
        clubePartidaReturnDTO.setPartidaId(clubePartida.getPartidaId());
        clubePartidaReturnDTO.setGols(clubePartida.getGols());
        clubePartidaReturnDTO.setMandante(clubePartida.isMandante());

        return clubePartidaReturnDTO;
    }
}