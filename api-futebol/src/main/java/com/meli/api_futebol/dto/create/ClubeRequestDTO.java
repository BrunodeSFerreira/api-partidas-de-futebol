package com.meli.api_futebol.dto.create;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.api_futebol.model.EstadosBrasileiros;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClubeRequestDTO {

    private String nomeClube;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EstadosBrasileiros estadosBrasileiros;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;

    public ClubeRequestDTO() {
    }

    public ClubeRequestDTO(String nomeClube, EstadosBrasileiros estadosBrasileiros, LocalDateTime dataCriacao) {
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


}
