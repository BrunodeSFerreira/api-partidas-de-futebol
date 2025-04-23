package com.meli.api_futebol.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
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
