package com.meli.api_futebol.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Table(name = "CLUBE")
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeClube;
    private EstadosBrasileiros estadosBrasileiros;
    private LocalDateTime dataCriacao;
    private boolean statusAtividade = true;

    @OneToMany(mappedBy = "clube", cascade = CascadeType.ALL)
    private List<ClubePartida> clubePartidas = Collections.synchronizedList(new ArrayList<>());

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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public List<ClubePartida> getClubePartidas() {
        return clubePartidas;
    }

    public void setClubePartidas(List<ClubePartida> clubePartidas) {
        this.clubePartidas = clubePartidas;
    }
}
