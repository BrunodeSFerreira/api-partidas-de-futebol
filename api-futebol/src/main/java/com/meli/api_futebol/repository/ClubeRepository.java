package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
}
