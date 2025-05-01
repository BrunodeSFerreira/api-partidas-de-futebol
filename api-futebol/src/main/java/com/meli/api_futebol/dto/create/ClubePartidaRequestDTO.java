package com.meli.api_futebol.dto.create;

public class ClubePartidaRequestDTO {


    private Long clubeId;
    private int gols;
    private boolean mandante;

    public ClubePartidaRequestDTO() {
    }

    public Long getClubeId() {
        return clubeId;
    }

    public void setClubeId(Long clubeId) {
        this.clubeId = clubeId;
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
