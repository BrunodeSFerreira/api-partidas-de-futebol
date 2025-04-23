package com.meli.api_futebol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "estadioId")
    private Estadio estadio;


    @OneToMany(mappedBy = "partida")
    private List<ClubePartida> clubesParticipates;

}
