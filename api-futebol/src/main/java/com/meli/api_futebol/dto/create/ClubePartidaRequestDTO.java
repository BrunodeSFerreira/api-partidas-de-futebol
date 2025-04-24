package com.meli.api_futebol.dto.create;

public class ClubePartidaRequestDTO {


    private Long clubeId;
    private Long partidaId;
    private int gols;
    private boolean mandante;

    public ClubePartidaRequestDTO() {
    }

    public ClubePartidaRequestDTO(Long clubeId, Long partidaId, int gols, boolean mandante) {
        this.clubeId = clubeId;
        this.partidaId = partidaId;
        this.gols = gols;
        this.mandante = mandante;
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
