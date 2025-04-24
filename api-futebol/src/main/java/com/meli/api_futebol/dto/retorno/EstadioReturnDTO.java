package com.meli.api_futebol.dto.retorno;

import java.util.List;

public class EstadioReturnDTO {

    private Long id;
    private String nomeEstadio;
    private List<PartidaReturnDTO> partidas;

    public EstadioReturnDTO(Long id, String nomeEstadio, List<PartidaReturnDTO> partidas) {
        this.id = id;
        this.nomeEstadio = nomeEstadio;
        this.partidas = partidas;
    }

    public EstadioReturnDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

    public List<PartidaReturnDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaReturnDTO> partidas) {
        this.partidas = partidas;
    }
}
