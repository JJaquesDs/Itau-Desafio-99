package com.jjaques.itauVaga99.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class Transacao {

    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public Transacao(Double valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
