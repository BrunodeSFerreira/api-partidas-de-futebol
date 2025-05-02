package com.meli.api_futebol.repository;
import com.meli.api_futebol.model.ClubePartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubePartidaRepository extends JpaRepository<ClubePartida, Long> {
}
