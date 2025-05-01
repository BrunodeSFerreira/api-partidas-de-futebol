package com.meli.api_futebol.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PartidaRequestDTO {

    //@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora;
    private Long estadioId;
    private List<ClubePartidaRequestDTO> clubeParticipantes = new ArrayList<>();

    public PartidaRequestDTO() {
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getEstadioId() {
        return estadioId;
    }

    public void setEstadioId(Long estadioId) {
        this.estadioId = estadioId;
    }

    public List<ClubePartidaRequestDTO> getClubeParticipantes() {
        return clubeParticipantes;
    }

    public void setClubeParticipantes(List<ClubePartidaRequestDTO> clubeParticipantes) {
        this.clubeParticipantes = clubeParticipantes;
    }
}
