package com.meli.api_futebol.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
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
    private LocalDate dataCriacao;
    private boolean statusAtividade = true;

    @OneToMany(mappedBy = "clube")
    private List<ClubePartida> clubePartidas;

}
