package com.meli.api_futebol.service.estadio;

import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.repository.EstadioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstadioCadastroServiceImpl implements iEstadioCadastroService {

    private final EstadioRepository estadioRepository;

    @Override
    public Estadio salvarEstadio(Estadio estadio) {

        List<Estadio> listaEstadios = estadioRepository.findAll().stream()
                .filter(estadio1 -> estadio1.getNomeEstadio().equalsIgnoreCase(estadio.getNomeEstadio()))
                .collect(Collectors.toList());
        if (!listaEstadios.isEmpty()) {
            log.error("[Erro] Estádio de nome {} já cadastrado.", estadio.getNomeEstadio());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Estadio " + estadio.getNomeEstadio() + "já cadastrado!");
        }
        if (estadio.getNomeEstadio().length() < 3) {
            log.error("[Erro] Nome do Estádio não pode ter menos que três caracteres.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome do Estádio não pode ter menos que três caracteres.");
        }

        return estadioRepository.save(estadio);
    }
}
