package com.meli.api_futebol.service.partida;

import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Partida;

public interface iPartidaCriarService {

    Partida criarPartida(PartidaRequestDTO partida);

}
