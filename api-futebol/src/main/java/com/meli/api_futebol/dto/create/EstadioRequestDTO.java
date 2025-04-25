package com.meli.api_futebol.dto.create;

public class EstadioRequestDTO {

    private String nomeEstadio;

    public EstadioRequestDTO(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;

    }

    public EstadioRequestDTO() {
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

}
