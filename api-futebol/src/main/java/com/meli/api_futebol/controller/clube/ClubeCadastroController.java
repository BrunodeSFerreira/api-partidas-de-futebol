package com.meli.api_futebol.controller.clube;

import com.meli.api_futebol.dto.create.ClubeRequestDTO;
import com.meli.api_futebol.dto.create.mapper.ClubeMapperDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.service.clube.ClubeCadastroServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clube")
public class ClubeCadastroController {

    public final ClubeCadastroServiceImpl clubeCadastroService;

    @PostMapping
    public ResponseEntity<Clube> salvarClube(@RequestBody @Valid ClubeRequestDTO clube) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clubeCadastroService.salvarClube(ClubeMapperDTO.toEntity(clube)));
    }

}
