package com.meli.api_futebol.repository;

import com.meli.api_futebol.dto.retorno.ClubeReturnDTO;
import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.EstadosBrasileiros;
import com.meli.api_futebol.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {

    Page<Clube> findByStatusAtividadeTrue(Pageable pageable);
    Page<Clube> findByNomeClubeContainingIgnoreCaseAndStatusAtividadeTrue (String nome, Pageable pageable);

    Page<Clube> findByEstadosBrasileirosAndStatusAtividadeTrue(EstadosBrasileiros estado, Pageable pageable);

    Page<Clube> findByStatusAtividade(boolean status, Pageable pageable);


}
