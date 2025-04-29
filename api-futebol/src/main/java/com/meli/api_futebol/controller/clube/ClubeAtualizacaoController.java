package com.meli.api_futebol.controller.clube;

import com.meli.api_futebol.dto.create.ClubeRequestDTO;
import com.meli.api_futebol.dto.create.mapper.ClubeMapperDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.service.clube.ClubeAtualizacaoServiceImpl;
import com.meli.api_futebol.service.clube.ClubeCadastroServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clube/atualizacao")
public class ClubeAtualizacaoController {

    private final ClubeAtualizacaoServiceImpl clubeAtualizacaoService;

    @PutMapping("/nome/{id}")
    public ResponseEntity<Clube> atualizarNome(@PathVariable Long id, @RequestBody @Valid ClubeRequestDTO nomeDto) {
        Clube nome = ClubeMapperDTO.toEntity(id, nomeDto);
        return ResponseEntity.status(HttpStatus.OK).body(clubeAtualizacaoService.atualizarNome(id, nome));
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<Clube> editarEstado(@PathVariable Long id, @RequestBody @Valid ClubeRequestDTO estadoDto) {
        Clube estado = ClubeMapperDTO.toEntity(id, estadoDto);
        return ResponseEntity.status(HttpStatus.OK).body(clubeAtualizacaoService.editarEstado(id, estado));
    }

    @PutMapping("/data-criacao/{id}")
    public ResponseEntity<Clube> editarDataCriacao(@PathVariable Long id, @RequestBody @Valid ClubeRequestDTO dataDto) {
        Clube data = ClubeMapperDTO.toEntity(id, dataDto);
        return ResponseEntity.status(HttpStatus.OK).body(clubeAtualizacaoService.editarDataCriacao(id, data));
    }

}
