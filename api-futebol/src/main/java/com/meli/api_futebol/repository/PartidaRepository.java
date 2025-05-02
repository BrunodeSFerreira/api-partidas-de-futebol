package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
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


   /* List<Partida> findAllByDataHoraBetweenAndClubesParticipantesClube_idNotNull(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("clubeId") Long clubeId);*/

    /*@Query("SELECT p FROM Partida p WHERE p.dataHora BETWEEN :inicio AND :fim AND p.clubesParticipates.clube = :clubeId")
    List<Partida> findAllByDataHoraBetweenAndClube_id(
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim,
            @Param("clubeId") Long clubeId
    );*/
}
