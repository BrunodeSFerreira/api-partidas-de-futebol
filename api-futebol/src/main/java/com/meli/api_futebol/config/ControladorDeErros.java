package com.meli.api_futebol.config;

import com.meli.api_futebol.exception.ErroPadrao;
import com.meli.api_futebol.exception.ObjetoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ControladorDeErros {
/*

    @ExceptionHandler({ObjetoNaoEncontradoException.class})
    public ResponseEntity<Void> objetoNaoEncontradoException (ObjetoNaoEncontradoException ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.notFound().build();
    }
*/
    /*
    @ExceptionHandler({Exception.class, ResponseStatusException.class})
    public ResponseEntity<ErroPadrao> errosGenericosException(Exception ex, ResponseStatusException exx) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getMessage());
        log.error("[Erro] {}", ex.getMessage());
        return ResponseEntity.status(exx.getStatusCode()).body(erroPadrao);
    }
/*
    @ExceptionHandler({MethodArgumentNotValidException.class, ResponseStatusException.class})
    public ResponseEntity<ErroPadrao> argumentoNaoValidoException(MethodArgumentNotValidException ex, ResponseStatusException exx) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem("Ocorreu um erro na validação dos campos.");
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagemErroCampo = erro.getDefaultMessage();
            erros.put(campo, mensagemErroCampo);
        });
        erroPadrao.setErrors(erros);

        return ResponseEntity.status(exx.getStatusCode()).body(erroPadrao);
    }*/

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<Void> objetoNaoEncontradoException(ObjetoNaoEncontradoException ex) {
        log.error("[Erro] {}", ex.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErroPadrao> errosGenericosException(ResponseStatusException ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getReason());
        log.error("[Erro] {}", ex.getReason());
        return ResponseEntity.status(ex.getStatusCode()).body(erroPadrao);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadrao> argumentoNaoValidoException(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagemErroCampo = erro.getDefaultMessage();
            erros.put(campo, mensagemErroCampo);
        });

        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem("Ocorreu um erro na validação dos campos.");
        erroPadrao.setErrors(erros);

        return ResponseEntity.badRequest().body(erroPadrao);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroPadrao> handleGenericException(Exception ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem("Ocorreu um erro inesperado.");
        log.error("[Erro] {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erroPadrao);
    }

    }

