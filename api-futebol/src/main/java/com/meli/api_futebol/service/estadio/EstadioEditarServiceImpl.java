package com.meli.api_futebol.service.estadio;

import com.meli.api_futebol.dto.create.EstadioRequestDTO;
import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.repository.EstadioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class EstadioEditarServiceImpl implements iEstadioEditarService{

    private final EstadioRepository estadioRepository;

    @Override
    public Estadio editarNomeEstadio(Long id, Estadio estadio) {
        List <Estadio> listaEstadios = estadioRepository.findAll().stream()
                .filter(estadio1 -> estadio1.getNomeEstadio().equalsIgnoreCase(estadio.getNomeEstadio())).toList();

        estadioRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "ID de Estádio não existe."));

        if (!listaEstadios.isEmpty()){
            throw new ResponseStatusException((HttpStatus.CONFLICT), "Não é possível cadastrar dois Estádios com o mesmo nome.");
        }

        if (estadio.getNomeEstadio().length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do Estádio deve conter no mínimo 3 letras.");
        }

        log.info("Nome editado com sucesso.");
        return estadioRepository.save(estadio);
    }
}
