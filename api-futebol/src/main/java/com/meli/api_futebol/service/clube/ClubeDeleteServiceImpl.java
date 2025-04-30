package com.meli.api_futebol.service.clube;


import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.repository.ClubeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClubeDeleteServiceImpl implements iClubeDeleteService {

    private final ClubeRepository clubeRepository;

    @Override
    public void inativarClube(Long id) {
        Optional<Clube> optionalClube = clubeRepository.findById(id);
        if (optionalClube.isPresent()) {
            Clube clube = optionalClube.get();
            clube.setStatusAtividade(false);
            clubeRepository.save(clube);
            log.info("Inativando clube {}", id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado.");
        }
    }

}
