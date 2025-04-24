package com.meli.api_futebol.repository;
import com.meli.api_futebol.model.ClubePartida;
import com.meli.api_futebol.model.ClubePartidaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubePartidaRepository extends JpaRepository<ClubePartida, ClubePartidaId> {
}
