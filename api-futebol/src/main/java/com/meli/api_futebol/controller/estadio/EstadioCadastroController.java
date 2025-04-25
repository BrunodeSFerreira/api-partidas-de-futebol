package com.meli.api_futebol.controller.estadio;

import com.meli.api_futebol.dto.create.EstadioRequestDTO;
import com.meli.api_futebol.dto.create.mapper.EstadioMapperDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.service.estadio.EstadioCadastroServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estadio")
public class EstadioCadastroController {

    private final EstadioCadastroServiceImpl estadioCadastroService;

    @PostMapping
    public ResponseEntity<Estadio> salvarEstadio(@RequestBody @Valid EstadioRequestDTO estadio) {
        return ResponseEntity.status(HttpStatus.CREATED).
                body(estadioCadastroService.salvarEstadio(EstadioMapperDTO.toEntity(estadio)));
    }

}
