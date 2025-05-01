package com.meli.api_futebol.dto.retorno.mapper;

import com.meli.api_futebol.dto.retorno.EstadioReturnDTO;
import com.meli.api_futebol.dto.retorno.PartidaReturnDTO;
import com.meli.api_futebol.model.Estadio;

import java.util.List;
import java.util.stream.Collectors;

public class EstadioReturnMapperDTO {

    public static EstadioReturnDTO entityToDTO(Estadio estadio) {
        EstadioReturnDTO estadioReturnDTO = new EstadioReturnDTO();
        estadioReturnDTO.setId(estadio.getId());
        estadioReturnDTO.setNomeEstadio(estadio.getNomeEstadio());


       /*List<PartidaReturnDTO> partidaReturnDTOS = estadio.getPartidas().stream().map( partida ->
                {
                    PartidaReturnDTO partidaReturnDTO = new PartidaReturnDTO();
                    partidaReturnDTO.setId(partida.getId());
                    partidaReturnDTO.setDataHora(partida.getDataHora());
                    partidaReturnDTO.setEstadioId(partida.getEstadio().getId());
                    return partidaReturnDTO;
                }
                ).collect(Collectors.toList());
        estadioReturnDTO.setPartidas(partidaReturnDTOS);*/
        return estadioReturnDTO;
    }

}
