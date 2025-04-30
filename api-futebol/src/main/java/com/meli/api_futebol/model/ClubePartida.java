
package com.meli.api_futebol.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CLUBE_PARTIDA")
public class ClubePartida {

    @EmbeddedId
    private ClubePartidaId id; // Esta é a chave composta que tem os IDs do clube e da partida

    @ManyToOne
    @MapsId("clubeId")
    private Clube clube;

    @ManyToOne
    @MapsId("partidaId")
    private Partida partida;

    private int gols;
    private boolean mandante;

    public int getGols() {
        return gols;
    }

    public boolean isMandante() {
        return mandante;
    }

    public void setMandante(boolean mandante) {
        this.mandante = mandante;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public Long getClubeId() {
        return id.getClubeId();
    }

    public Long getPartidaId() {
        return id.getPartidaId();
    }
}
