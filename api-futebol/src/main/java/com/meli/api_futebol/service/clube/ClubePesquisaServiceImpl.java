package com.meli.api_futebol.service.clube;

import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;
import com.meli.api_futebol.dto.retorno.mapper.ClubeReturnMapperDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.EstadosBrasileiros;
import com.meli.api_futebol.repository.ClubeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;


@Service
@Slf4j
@RequiredArgsConstructor
public class ClubePesquisaServiceImpl implements iClubePesquisaService {

    private final ClubeRepository clubeRepository;

    @Override
    public Clube buscarClubePorId(Long id) {
        return clubeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clube não encontrado."));
    }

    @Override
    public Page<ClubeReturnDTO> buscarTodosOsClubes(Pageable pageable) {
        Page<Clube> clube = clubeRepository.findByStatusAtividadeTrue(pageable);
        if (clube.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.OK);
        }
        log.info("Pesquisando todos os clubes.");
        return clube.map(ClubeReturnMapperDTO::entityToDTO);
    }

    @Override
    public Page<ClubeReturnDTO> buscarClubePorNome(String nome, Pageable pageable) {
        Page<Clube> clubes = clubeRepository.findByNomeClubeContainingIgnoreCaseAndStatusAtividadeTrue(nome, pageable);

        if (clubes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.OK);
        }
        log.info("Pesquisando clube de nome {}", nome);
        return clubes.map(ClubeReturnMapperDTO::entityToDTO);
    }

    @Override
    public Page<ClubeReturnDTO> buscarClubesPorEstado(String estadoString, Pageable pageable) {
        EstadosBrasileiros estado = Arrays.stream(EstadosBrasileiros.values())
                .filter(e -> e.getSigla().equalsIgnoreCase(estadoString))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.OK));

        Page<Clube> clubes = clubeRepository.findByEstadosBrasileirosAndStatusAtividadeTrue(estado, pageable);
        return clubes.map(ClubeReturnMapperDTO::entityToDTO);
    }

    @Override
    public Page<ClubeReturnDTO> buscarClubePorStatusAtividade(String statusClube, Pageable pageable) {
        boolean status;

        if ("ativo".equalsIgnoreCase(statusClube)) {
            status = true;
        } else if ("inativo".equalsIgnoreCase(statusClube)) {
            status = false;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status deve ser 'ativo' ou 'inativo'.");
        }
        Page<Clube> clubes = clubeRepository.findByStatusAtividade(status, pageable);

        if (clubes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.OK);
        }

        log.info("Pesquisando clubes pelo status de atividade: {}", statusClube);
        return clubes.map(ClubeReturnMapperDTO::entityToDTO);
    }
}
