package com.meli.api_futebol.dto.create;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.api_futebol.model.EstadosBrasileiros;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class ClubeRequestDTO {

    @NotNull(message = "Nome do Clube não pode ser nulo.")
    @Size(min = 2, message = "O nome do Clube não pode ter menos que dois caracteres.")
    private String nomeClube;

    @NotNull(message = "É necessário informar o Estado de origem do clube.")
    private EstadosBrasileiros estadosBrasileiros;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Necessário informar data de criação do Clube.")
    private LocalDate dataCriacao;

    private List<ClubePartidaRequestDTO> clubePartidas;

    public ClubeRequestDTO() {
    }

    public ClubeRequestDTO(String nomeClube, EstadosBrasileiros estadosBrasileiros, LocalDate dataCriacao, List<ClubePartidaRequestDTO> clubePartidas) {
        this.nomeClube = nomeClube;
        this.estadosBrasileiros = estadosBrasileiros;
        this.dataCriacao = dataCriacao;
        this.clubePartidas = clubePartidas;
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


    public List<ClubePartidaRequestDTO> getClubePartidas() {
        return clubePartidas;
    }

    public void setClubePartidas(List<ClubePartidaRequestDTO> clubePartidas) {
        this.clubePartidas = clubePartidas;
    }
}
