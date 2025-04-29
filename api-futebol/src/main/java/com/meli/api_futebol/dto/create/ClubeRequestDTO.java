package com.meli.api_futebol.dto.create;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.api_futebol.model.EstadosBrasileiros;


import java.time.LocalDate;

public class ClubeRequestDTO {

    private String nomeClube;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EstadosBrasileiros estadosBrasileiros;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao;

    public ClubeRequestDTO() {
    }

    public ClubeRequestDTO(String nomeClube, EstadosBrasileiros estadosBrasileiros, LocalDate dataCriacao) {
        this.nomeClube = nomeClube;
        this.estadosBrasileiros = estadosBrasileiros;
        this.dataCriacao = dataCriacao;

    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public EstadosBrasileiros getEstadosBrasileiros() {
        return estadosBrasileiros;
    }

    public void setEstadosBrasileiros(EstadosBrasileiros estadosBrasileiros) {
        this.estadosBrasileiros = estadosBrasileiros;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


}
