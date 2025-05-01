package com.meli.api_futebol.dto.retorno;

import java.util.List;

public class EstadioReturnDTO {

    private Long id;
    private String nomeEstadio;
    //private List<PartidaReturnDTO> partidas;

    public EstadioReturnDTO(Long id, String nomeEstadio) {
        this.id = id;
        this.nomeEstadio = nomeEstadio;

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


}
