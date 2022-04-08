package br.com.zup.zenity.domain;

import java.util.Date;

public class Personas {

    private final Pessoa remetente;
    private final Date dataEnvio;
    private final Tipo tipo;
    private String descricao;

    public Personas(Pessoa remetente, Date dataEnvio, Tipo tipo) {
        this.remetente = remetente;
        this.dataEnvio = dataEnvio;
        this.tipo = tipo;
    }

    public Personas comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public enum Tipo {
        DESCONHECIDO, EM_DESENVOLVIMENTO, EVOLUTIVO, EVOLUTIVO_RAPIDO, TRANSFORMADOR
    }
}
