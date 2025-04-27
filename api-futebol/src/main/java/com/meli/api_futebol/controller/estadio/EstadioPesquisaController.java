package com.meli.api_futebol.controller.estadio;

import com.meli.api_futebol.dto.retorno.EstadioReturnDTO;
import com.meli.api_futebol.dto.retorno.mapper.EstadioReturnMapperDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.repository.EstadioRepository;
import com.meli.api_futebol.service.estadio.EstadioPesquisaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/estadio/pesquisa")
public class EstadioPesquisaController {

    private final EstadioPesquisaServiceImpl estadioPesquisaService;

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscarEstadioPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(estadioPesquisaService.buscarEstadioPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<EstadioReturnDTO>> listarTodosEstadios() {
        return ResponseEntity.status(HttpStatus.OK).body(estadioPesquisaService.listarTodosEstadios()) ;
    }

}
