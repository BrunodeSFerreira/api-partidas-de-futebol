package com.meli.api_futebol.config;

import com.meli.api_futebol.exception.ErroPadrao;
import com.meli.api_futebol.exception.ObjetoNaoEncontradoException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControladorDeErros {

    @ExceptionHandler({ObjetoNaoEncontradoException.class})
    public ResponseEntity<Void> objetoNaoEncontradoException (ObjetoNaoEncontradoException ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErroPadrao> errosGenericosException(Exception ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErroPadrao> argumentoNaoValidoException(MethodArgumentNotValidException ex) {
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }
}
