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

        List<ClubePartidaReturnDTO> clubePartidasDTO = partida.getClubesParticipates().stream()
                .map(cp -> {
                    ClubePartidaReturnDTO clubePartidaReturnDTO = new ClubePartidaReturnDTO();
                    clubePartidaReturnDTO.setId(cp.getId());
                    clubePartidaReturnDTO.setClubeId(cp.getClube().getId());
                    clubePartidaReturnDTO.setPartidaId(cp.getPartida().getId());
                    clubePartidaReturnDTO.setGols(cp.getGols());
                    clubePartidaReturnDTO.setMandante(cp.isMandante());
                    return clubePartidaReturnDTO;
                })
                .collect(Collectors.toList());

        partidaReturnDTO.setClubesParticipantes(clubePartidasDTO);
        return partidaReturnDTO;
    }
}