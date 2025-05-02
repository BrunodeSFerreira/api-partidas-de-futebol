package com.meli.api_futebol.dto.retorno.mapper.partida;

import com.meli.api_futebol.dto.create.PartidaRequestDTO;
import com.meli.api_futebol.model.Partida;
import com.meli.api_futebol.repository.ClubeRepository;
import com.meli.api_futebol.repository.EstadioRepository;
import com.meli.api_futebol.repository.PartidaRepository;
import com.meli.api_futebol.service.partida.PartidaEdicaoServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partida/atualizacao")
public class PartidaEdicaoController {

    private final PartidaEdicaoServiceImpl partidaEdicaoService;

    @PutMapping("/clubes/{id}")
    public ResponseEntity<Partida> atualizarClubes(@PathVariable Long id, @RequestBody @Valid PartidaRequestDTO partidaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaEdicaoService.atualizarClubes(id, partidaRequestDTO));
    }

    @PutMapping("/gols/{id}")
    public ResponseEntity<Partida> atualizarGols(@PathVariable Long id, @RequestBody @Valid PartidaRequestDTO partidaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaEdicaoService.atualizarGols(id, partidaRequestDTO));
    }
/*
    @PutMapping("/data-hora/{id}")
    public ResponseEntity<Partida> atualizarDataHora(@PathVariable Long id, @RequestBody @Valid PartidaRequestDTO partidaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaEdicaoService.atualizarDataHora(id, partidaRequestDTO));
    }
*/
    @PutMapping("/estadio/{id}")
    public ResponseEntity<Partida> atualizarEstadio(@PathVariable Long id, @RequestBody @Valid PartidaRequestDTO partidaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(partidaEdicaoService.atualizarEstadio(id, partidaRequestDTO));
    }



}
