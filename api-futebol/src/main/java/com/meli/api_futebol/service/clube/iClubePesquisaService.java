package com.meli.api_futebol.service.clube;

import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.EstadosBrasileiros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iClubePesquisaService {

    Clube buscarClubePorId(Long id);

    Page<ClubeReturnDTO> buscarTodosOsClubes(Pageable pageable);

    Page<ClubeReturnDTO> buscarClubePorNome(String nome, Pageable pageable);

    Page<ClubeReturnDTO> buscarClubesPorEstado(String estado, Pageable pageable);

    Page<ClubeReturnDTO> buscarClubePorStatusAtividade(String  status, Pageable pageable);


}
