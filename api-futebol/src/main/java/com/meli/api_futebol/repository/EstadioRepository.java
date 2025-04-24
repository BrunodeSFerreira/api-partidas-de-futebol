package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {
}
