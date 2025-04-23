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

}
