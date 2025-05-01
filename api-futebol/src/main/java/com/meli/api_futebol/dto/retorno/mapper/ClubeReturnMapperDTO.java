package com.meli.api_futebol.dto.retorno.mapper;
import com.meli.api_futebol.dto.retorno.ClubePartidaReturnDTO;
import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;
import com.meli.api_futebol.model.Clube;
import java.util.List;
import java.util.stream.Collectors;

public class ClubeReturnMapperDTO {

    public static ClubeReturnDTO entityToDTO(Clube clube) {
        ClubeReturnDTO clubeReturnDTO = new ClubeReturnDTO();
        clubeReturnDTO.setId(clube.getId());
        clubeReturnDTO.setNomeClube(clube.getNomeClube());
        clubeReturnDTO.setEstadosBrasileiros(clube.getEstadosBrasileiros());
        clubeReturnDTO.setDataCriacao(clube.getDataCriacao());
        clubeReturnDTO.setStatusAtividade(clube.isStatusAtividade());

        List<ClubePartidaReturnDTO> clubePartidasDTO = clube.getClubePartidas().stream()
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

        clubeReturnDTO.setClubePartidas(clubePartidasDTO);
        return clubeReturnDTO;
    }
}