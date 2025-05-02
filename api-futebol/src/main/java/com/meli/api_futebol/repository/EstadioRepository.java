package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {
   /* @Query("SELECT e FROM Estadio e WHERE e.id = :estadioId AND e.partidas.dataHora BETWEEN :inicio AND :fim")
    List<Estadio> findAllByPartidasDataHoraBetweenAndIdNot(
            @Param("estadioId") Long estadioId,
            @Param("inicio") LocalDateTime inicio,
            @Param("fim") LocalDateTime fim
    );
    List<Partida> findAllByPartidaDataHoraBetweenAndIdNotNull(Long estadioId, LocalDateTime inicioDoDia, LocalDateTime fimDoDia );*/
}
