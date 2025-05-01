package com.meli.api_futebol.dto.retorno;

import jakarta.persistence.Id;

public class ClubePartidaReturnDTO {

    private Long id;

    private Long clubeId;
    private Long partidaId;
    private int gols;
    private boolean mandante;

    public ClubePartidaReturnDTO(Long id, Long clubeId, Long partidaId, int gols, boolean mandante) {
        this.id = id;
        this.clubeId = clubeId;
        this.partidaId = partidaId;
        this.gols = gols;
        this.mandante = mandante;
    }

    public ClubePartidaReturnDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public boolean isMandante() {
        return mandante;
    }

    public void setMandante(boolean mandante) {
        this.mandante = mandante;
    }
}
