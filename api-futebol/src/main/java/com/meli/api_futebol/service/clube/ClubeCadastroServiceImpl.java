package com.meli.api_futebol.service.clube;

import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.EstadosBrasileiros;
import com.meli.api_futebol.repository.ClubeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClubeCadastroServiceImpl implements iClubeCadastroService {

    private final ClubeRepository clubeRepository;

    @Override
    public Clube salvarClube(Clube clube) {
        List<Clube> listaClubes = clubeRepository.findAll().stream()
                .filter(clube1 -> clube1.getNomeClube()
                        .equalsIgnoreCase(clube.getNomeClube()) && clube1.getEstadosBrasileiros().getSigla()
                        .equals(clube.getEstadosBrasileiros().getSigla())).toList();

        if (!listaClubes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nome de clube já existente no Estado "
                    + clube.getEstadosBrasileiros().getNome());
        }

        if (clube.getDataCriacao().isAfter(LocalDate.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é permitido inserir data posterior à data atual.");
        }

        if (clube.getNomeClube().length() < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é permitido criar Clube com que contenha menos de duas letras.");
        }

        if (!Arrays.stream(EstadosBrasileiros.values()).anyMatch(
                estadosBrasileiros -> estadosBrasileiros.equals(clube.getEstadosBrasileiros())
        )){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado informado é inexistente.");
        }

        log.info("Criando Clube {} do Estado de {}", clube.getNomeClube(), clube.getEstadosBrasileiros().getNome());
        return clubeRepository.save(clube);
    }

}
