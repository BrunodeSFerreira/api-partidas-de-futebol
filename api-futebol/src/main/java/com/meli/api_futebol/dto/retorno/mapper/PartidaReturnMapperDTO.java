package com.meli.api_futebol.dto.retorno.mapper;

import com.meli.api_futebol.dto.retorno.ClubePartidaReturnDTO;
import com.meli.api_futebol.dto.retorno.PartidaReturnDTO;
import com.meli.api_futebol.model.Partida;

import java.util.List;
import java.util.stream.Collectors;

public class PartidaReturnMapperDTO {

    public static PartidaReturnDTO entityToDTO(Partida partida) {
        PartidaReturnDTO partidaReturnDTO = new PartidaReturnDTO();
        partidaReturnDTO.setId(partida.getId());
        partidaReturnDTO.setDataHora(partida.getDataHora());
        partidaReturnDTO.setEstadioId(partida.getEstadio().getId());

        List<ClubePartidaReturnDTO> clubePartidaReturnDTO = partida.getClubesParticipates().stream()
                .map(cp -> {
                    ClubePartidaReturnDTO clubePartidaReturn = new ClubePartidaReturnDTO();

                    clubePartidaReturn.setClubeId(cp.getId().getClubeId());
                    clubePartidaReturn.setPartidaId(cp.getId().getPartidaId());
                    clubePartidaReturn.setGols(cp.getGols());
                    clubePartidaReturn.setMandante(cp.isMandante());

                    return clubePartidaReturn;
                })
                .collect(Collectors.toList());

        partidaReturnDTO.setClubesParticipantes(clubePartidaReturnDTO);

        return partidaReturnDTO;
    }
}