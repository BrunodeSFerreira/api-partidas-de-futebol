package com.meli.api_futebol.repository;

import com.meli.api_futebol.model.Clube;
import com.meli.api_futebol.model.EstadosBrasileiros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {

}
