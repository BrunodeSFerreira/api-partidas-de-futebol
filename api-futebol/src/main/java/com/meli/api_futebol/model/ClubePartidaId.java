package com.meli.api_futebol.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ClubePartidaId implements Serializable {

    private Long clubeId;
    private Long partidaId;

    public ClubePartidaId(Long clubeId, Long partidaId) {
        this.clubeId = clubeId;
        this.partidaId = partidaId;
    }

    public Long getClubeId() {
        return clubeId;
    }

    public void setClubeId(Long clubeId) {
        this.clubeId = clubeId;
    }

    public Long getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Long partidaId) {
        this.partidaId = partidaId;
    }
}
