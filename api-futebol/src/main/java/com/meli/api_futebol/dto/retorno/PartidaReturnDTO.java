package com.meli.api_futebol.dto.retorno;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class PartidaReturnDTO {

    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora;
    private Long estadioId;
    private List<ClubePartidaReturnDTO> clubesParticipantes;

    public PartidaReturnDTO(Long id, LocalDateTime dataHora, Long estadioId, List<ClubePartidaReturnDTO> clubesParticipantes) {
        this.id = id;
        this.dataHora = dataHora;
        this.estadioId = estadioId;
        this.clubesParticipantes = clubesParticipantes;
    }

    public PartidaReturnDTO() {
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

    public List<ClubePartidaReturnDTO> getClubesParticipantes() {
        return clubesParticipantes;
    }

    public void setClubesParticipantes(List<ClubePartidaReturnDTO> clubesParticipantes) {
        this.clubesParticipantes = clubesParticipantes;
    }
}
