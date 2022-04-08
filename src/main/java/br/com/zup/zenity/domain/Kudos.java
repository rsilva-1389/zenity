package br.com.zup.zenity.domain;

import java.util.Date;

public class Kudos {

    private final Tipo tipo;
    private final Pessoa remetente;
    private final Date dataEnvio;

    public enum Tipo {
        GRATIDAO, LIDERANCA_INSPIRADORA, OTIMO_TRABALHO, EXCELENTE_MENTOR
    }

    public Kudos(Tipo tipo, Pessoa remetente, Date dataEnvio) {
        this.tipo = tipo;
        this.remetente = remetente;
        this.dataEnvio = dataEnvio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Pessoa getRemetente() {
        return remetente;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }
}
