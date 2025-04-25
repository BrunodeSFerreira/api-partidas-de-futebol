package com.meli.api_futebol.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErroPadrao {

    private LocalDateTime dataHora;
    private String mensagem;
    private Map<String, String> errors;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
