package com.meli.api_futebol.service;

import com.meli.api_futebol.model.Estadio;
import com.meli.api_futebol.repository.EstadioRepository;
import com.meli.api_futebol.service.estadio.EstadioCadastroServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import static org.hibernate.sql.ast.Clause.CONFLICT;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EstadioCadastroServiceTest {


    @InjectMocks
    private EstadioCadastroServiceImpl estadioCadastroService;
    @Mock
    private EstadioRepository estadioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve cadastrar um Estádio.")
    void deveSalvarUmEstadio() {

        Estadio estadio = new Estadio();
        estadio.setId(1L);
        estadio.setNomeEstadio("Avaí");

        when(estadioRepository.findAll()).thenReturn(new ArrayList<>());
        when(estadioRepository.save(ArgumentMatchers.any(Estadio.class))).thenReturn(estadio);

        Estadio resultado = estadioCadastroService.salvarEstadio(estadio);

        assertEquals(estadio, resultado);
        verify(estadioRepository).save(estadio);

    }

  /*  @Test
    public void testSalvarEstadio_jaCadastrado() {
        // Arrange
        Estadio estadioExistente = new Estadio();
        estadioExistente.setNomeEstadio("Estadio Teste");

        when(estadioRepository.findAll()).thenReturn(Collections.singletonList(estadioExistente));

        Estadio estadioNovo = new Estadio();
        estadioNovo.setNomeEstadio("Estadio Teste");

        // Act & Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            estadioCadastroService.salvarEstadio(estadioNovo);
        });

        assertEquals("Estadio Estadio Teste já cadastrado!", exception.getReason());
        assertEquals(CONFLICT, exception.getReason());
    }*/

}
