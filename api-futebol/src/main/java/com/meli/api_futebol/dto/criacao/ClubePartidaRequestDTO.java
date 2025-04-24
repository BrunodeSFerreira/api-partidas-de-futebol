package com.meli.api_futebol.dto.criacao;
 import com.meli.api_futebol.model.ClubePartidaId;
import jakarta.validation.constraints.NotNull;

public class ClubePartidaRequestDTO {

    @NotNull(message = "Id não pode ter valor nulo.")
    private ClubePartidaId id;
    private Long clubeId;
    private Long partidaId;
    private int gols;
    private boolean mandante;

    public ClubePartidaRequestDTO() {
    }

    public ClubePartidaRequestDTO(ClubePartidaId id, Long clubeId, Long partidaId, int gols, boolean mandante) {
        this.id = id;
        this.clubeId = clubeId;
        this.partidaId = partidaId;
        this.gols = gols;
        this.mandante = mandante;
    }

    public ClubePartidaId getId() {
        return id;
    }

    public void setId(ClubePartidaId id) {
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
