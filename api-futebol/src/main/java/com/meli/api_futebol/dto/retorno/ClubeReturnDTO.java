package com.meli.api_futebol.dto.retorno;

import com.meli.api_futebol.model.EstadosBrasileiros;

import java.time.LocalDate;
import java.util.List;

public class ClubeReturnDTO {

    private Long id;
    private String nomeClube;
    private EstadosBrasileiros estadosBrasileiros;
    private LocalDate dataCriacao;
    private boolean statusAtividade;
    private List<ClubePartidaReturnDTO> clubePartidas;

    public ClubeReturnDTO(Long id, String nomeClube, EstadosBrasileiros estadosBrasileiros, LocalDate dataCriacao, boolean statusAtividade, List<ClubePartidaReturnDTO> clubePartidas) {
        this.id = id;
        this.nomeClube = nomeClube;
        this.estadosBrasileiros = estadosBrasileiros;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
        this.clubePartidas = clubePartidas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public List<ClubePartidaReturnDTO> getClubePartidas() {
        return clubePartidas;
    }

    public void setClubePartidas(List<ClubePartidaReturnDTO> clubePartidas) {
        this.clubePartidas = clubePartidas;
    }
}
