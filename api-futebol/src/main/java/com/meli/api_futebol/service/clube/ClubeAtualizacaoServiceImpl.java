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
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClubeAtualizacaoServiceImpl implements iClubeAtualizacaoService{

    private final ClubeRepository clubeRepository;

    @Override
    public Clube atualizarNome(Long id, Clube nome) {
        List<Clube> listaClubeComMesmoNome = clubeRepository.findAll().stream()
                .filter(clube -> clube.getNomeClube().equalsIgnoreCase(nome.getNomeClube())).toList();

        Clube clubeCadastrado = buscarClubePorId(id);

        if (nome.getNomeClube() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Necessário informar o nome do Clube");
        }
        if (nome.getNomeClube().length() < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário que o nome possua duas ou mais letras.");
        }

        if (!listaClubeComMesmoNome.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Nome de clube já existente para o mesmo Estado.");
        }

        log.info("Editando nome do clube de {} para {}", clubeCadastrado.getNomeClube(), nome.getNomeClube());
        clubeCadastrado.setNomeClube(nome.getNomeClube());
        return clubeRepository.save(clubeCadastrado);
    }

    public Clube editarEstado(Long id, Clube estado) {
        Clube clubeCadastrado = buscarClubePorId(id);

        if (!Arrays.stream(EstadosBrasileiros.values()).anyMatch(
                estadosBrasileiros -> estadosBrasileiros.equals(estado.getEstadosBrasileiros())
        )) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado informado é inexistente.");
        }

        log.info("Atualizando Estado do Clube {} para {}", clubeCadastrado.getNomeClube(), estado.getEstadosBrasileiros());
        clubeCadastrado.setEstadosBrasileiros(estado.getEstadosBrasileiros());
        return clubeRepository.save(clubeCadastrado);
    }

    public Clube editarDataCriacao(Long id, Clube clube) {
        Clube clubeCadastrado = buscarClubePorId(id);

        if (clube.getDataCriacao().isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de criação não pode ser posterior à data atual.");
        }

        // FALTA FAZER A EXCEÇÃO PARA NÃO PERMITIR A EDIÇÃO POSTERIOR À ALGUMA PARTIDA JÁ CADASTRADA
        log.info("Atualizando a data de criação do Clube {} para {}", clubeCadastrado.getNomeClube(), clube.getDataCriacao());
        clubeCadastrado.setDataCriacao(clube.getDataCriacao());
        return clubeRepository.save(clubeCadastrado);
    }

    private Clube buscarClubePorId(Long id) {
        Clube clubeCadastrado = clubeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube de Id " + id + " não cadastrado."));
        return clubeCadastrado;
    }

}
