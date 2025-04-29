package com.meli.api_futebol.service.clube;

import com.meli.api_futebol.model.Clube;

public interface iClubeAtualizacaoService {

    Clube atualizarNome(Long id, Clube nome);

    Clube editarEstado(Long id, Clube estado);

    Clube editarDataCriacao(Long id, Clube clube);

}
