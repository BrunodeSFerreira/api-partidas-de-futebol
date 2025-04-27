package com.meli.api_futebol.service.estadio;

import com.meli.api_futebol.dto.retorno.EstadioReturnDTO;
import com.meli.api_futebol.model.Estadio;

import java.util.List;

public interface iEstadioPesquisaService {

    Estadio buscarEstadioPorId(Long id);

    List <EstadioReturnDTO> listarTodosEstadios();

}
