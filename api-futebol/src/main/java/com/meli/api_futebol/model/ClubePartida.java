package com.meli.api_futebol.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CLUBE_PARTIDA ")
public class ClubePartida {

    @EmbeddedId
    private ClubePartidaId id;

    @ManyToOne
    @MapsId("clubeId")
    private Clube clube;

    @ManyToOne
    @MapsId("partidaId")
    private Partida partida;

    private int gols;
    private boolean mandante;

}
