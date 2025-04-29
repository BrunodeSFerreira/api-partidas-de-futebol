package com.meli.api_futebol.controller.clube;

import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.service.clube.ClubeDeleteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clube/delete/{id}")
public class ClubeDeleteController {

    private final ClubeDeleteServiceImpl clubeDeleteService;

    @DeleteMapping
    public ResponseEntity<Void> inativarClube(@PathVariable Long id) {
        clubeDeleteService.inativarClube(id);
        return ResponseEntity.noContent().build();
    }

}
