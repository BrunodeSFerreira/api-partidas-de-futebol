package com.meli.api_futebol.service.estadio;

import com.meli.api_futebol.dto.create.mapper.EstadioMapperDTO;
import com.meli.api_futebol.dto.retorno.EstadioReturnDTO;
import com.meli.api_futebol.dto.retorno.mapper.EstadioReturnMapperDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.repository.EstadioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstadioPesquisaServiceImpl implements iEstadioPesquisaService{

    private final EstadioRepository estadioRepository;

    @Override
    public Estadio buscarEstadioPorId(Long id) {
        Estadio estadio = estadioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Não há Estádio com o Id " + id));
        log.info("Pesquisando Estádio de nome {}", estadio.getNomeEstadio());
        return estadio;
    }

    @Override
    public List<EstadioReturnDTO> listarTodosEstadios() {
        log.info("Listando todos os Estádios.");
        return estadioRepository.findAll().stream()
                .map(estadio -> EstadioReturnMapperDTO.entityToDTO(estadio)).collect(Collectors.toList());
    }
}
