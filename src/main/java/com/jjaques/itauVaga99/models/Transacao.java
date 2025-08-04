package com.jjaques.itauVaga99.models;

import java.time.OffsetDateTime;

public class Transacao {

    private double valor;
    private OffsetDateTime dataHora;

    public Transacao(double valor, OffsetDateTime dataHora){
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
