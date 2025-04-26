package com.meli.api_futebol.service.estadio;

import com.meli.api_futebol.dto.create.EstadioRequestDTO;
import com.meli.api_futebol.model.Estadio;

public interface iEstadioEditarService {

    Estadio editarNomeEstadio(Long id, Estadio estadio);



}
