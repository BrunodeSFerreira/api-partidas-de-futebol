package com.meli.api_futebol.dto.create;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class EstadioRequestDTO {

    @NotBlank(message = "O nome do Estádio não pode ser nulo/branco.")
    @Min(value = 3, message = "O nome deve contar pelo menos três caracteres.")
    private String nomeEstadio;
    @NotNull(message = "Necessário informar o número identificador do Estádio.")
    private List<PartidaRequestDTO> partidas;

    public EstadioRequestDTO(String nomeEstadio, List<PartidaRequestDTO> partidas) {
        this.nomeEstadio = nomeEstadio;
        this.partidas = partidas;
    }

    public EstadioRequestDTO() {
    }

    public String getNomeEstadio() {
        return nomeEstadio;
    }

    public void setNomeEstadio(String nomeEstadio) {
        this.nomeEstadio = nomeEstadio;
    }

    public List<PartidaRequestDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaRequestDTO> partidas) {
        this.partidas = partidas;
    }
}
