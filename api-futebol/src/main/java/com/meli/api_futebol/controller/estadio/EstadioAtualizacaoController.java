package com.meli.api_futebol.controller.estadio;

import com.meli.api_futebol.dto.create.EstadioRequestDTO;
import com.meli.api_futebol.dto.create.mapper.EstadioMapperDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.service.estadio.EstadioEditarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estadio/atualizacao")
public class EstadioAtualizacaoController {

    private final EstadioEditarServiceImpl estadioEditarService;

    @PutMapping("/{id}")
    public ResponseEntity<Estadio> atualizarNomeEstadio(@PathVariable Long id, @RequestBody EstadioRequestDTO estadio) {
        Estadio estadioEntity = EstadioMapperDTO.toEntity(id, estadio);
        return ResponseEntity.status(HttpStatus.OK).body(estadioEditarService.editarNomeEstadio(id, estadioEntity));
    }

}
