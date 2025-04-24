package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
