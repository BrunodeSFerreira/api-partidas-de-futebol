package com.meli.api_futebol.controller.clube;


import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;

import com.meli.api_futebol.dto.retorno.mapper.ClubeReturnMapperDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.service.clube.ClubePesquisaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clube/pesquisa")
public class ClubePesquisaController {

    private final ClubePesquisaServiceImpl clubePesquisaService;

   @GetMapping("/{id}")
    public ResponseEntity<ClubeReturnDTO> buscarClubePorId(@PathVariable Long id) {
        Clube clube = clubePesquisaService.buscarClubePorId(id);
        ClubeReturnDTO clubeReturnDTO = ClubeReturnMapperDTO.entityToDTO(clube);
        return ResponseEntity.ok(clubeReturnDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ClubeReturnDTO>> buscarTodosOsClubes(@PageableDefault(size = 5, sort = "nomeClube")Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clubePesquisaService.buscarTodosOsClubes(pageable));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Page<ClubeReturnDTO>> buscarClubePorNome(@PathVariable String nome,
                                                                   @PageableDefault(size = 5, sort = "nomeClube") Pageable pageable) {
       return ResponseEntity.status(HttpStatus.OK).body(clubePesquisaService.buscarClubePorNome(nome, pageable));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<Page<ClubeReturnDTO>> buscarClubesPorEstado(@PathVariable String estado,
                                                                      @PageableDefault(size = 5, sort = "nomeClube") Pageable pageable) {
        return ResponseEntity.ok(clubePesquisaService.buscarClubesPorEstado(estado, pageable));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Page<ClubeReturnDTO>> buscarClubePorStatusAtividade(@PathVariable String status,
                                                                              @PageableDefault(size = 5, sort = "nomeClube") Pageable pageable) {
        Page<ClubeReturnDTO> clubes = clubePesquisaService.buscarClubePorStatusAtividade(status, pageable);
        return ResponseEntity.ok(clubes);
    }
}
