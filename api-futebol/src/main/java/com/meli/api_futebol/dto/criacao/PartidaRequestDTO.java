package com.meli.api_futebol.dto.criacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PartidaRequestDTO {

    private Long id;
    private LocalDateTime dataHora;
    private Long estadioId;
    private List<ClubePartidaRequestDTO> clubeParticipantes;

    public PartidaRequestDTO(Long id, LocalDateTime dataHora, Long estadioId, List<ClubePartidaRequestDTO> clubeParticipantes) {
        this.id = id;
        this.dataHora = dataHora;
        this.estadioId = estadioId;
        this.clubeParticipantes = clubeParticipantes;
    }

    public PartidaRequestDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
