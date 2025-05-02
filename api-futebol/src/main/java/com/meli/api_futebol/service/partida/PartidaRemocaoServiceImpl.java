package com.meli.api_futebol.service.partida;

import com.meli.api_futebol.model.Partida;
import com.meli.api_futebol.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PartidaRemocaoServiceImpl implements iPartidaRemocaoService{

    private final PartidaRepository partidaRepository;

    @Override
    public void removerPartida(Long id) {
        partidaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partida não encontrada."));

         partidaRepository.deleteById(id);
    }

}
