package com.meli.api_futebol.service.partida;

import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Partida;

public interface iPartidaEdicaoService {

    Partida atualizarGols(Long id, PartidaRequestDTO request);

    Partida atualizarClubes(Long id, PartidaRequestDTO request);

    Partida atualizarEstadio(Long id, PartidaRequestDTO request);

    //Partida atualizarDataHora(Long id, PartidaRequestDTO request);
}
