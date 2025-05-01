package com.meli.api_futebol.controller.partida;

import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Partida;
import com.meli.api_futebol.service.partida.PartidaCriarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class PartidaCriacaoController {

    private final PartidaCriarServiceImpl partidaCriarService;

    @PostMapping("/partida")
    public ResponseEntity<Partida> criarPartida(@RequestBody PartidaRequestDTO partidaRequestDTO) {
        Partida partida = partidaCriarService.criarPartida(partidaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(partida);
    }

}
