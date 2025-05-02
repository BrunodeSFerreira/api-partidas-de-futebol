package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    List<Partida> findAllByEstadioId(Long estadioId);

    List<Partida> findAllByEstadioIdAndDataHoraBetween(
            Long estadioId,
            LocalDateTime inicioDoDia,
            LocalDateTime fimDoDia
    );

}
