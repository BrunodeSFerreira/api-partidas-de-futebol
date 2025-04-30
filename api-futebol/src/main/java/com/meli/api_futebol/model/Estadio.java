package com.meli.api_futebol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ESTADIO")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeEstadio;

    @OneToMany(mappedBy = "estadio")
    private List<Partida> partidas;

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

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}
