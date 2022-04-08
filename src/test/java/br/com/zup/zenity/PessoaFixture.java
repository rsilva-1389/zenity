package br.com.zup.zenity;

import br.com.zup.zenity.domain.Pessoa;

import java.util.Arrays;
import java.util.Collection;

public class PessoaFixture {

    public static Collection<Pessoa> pessoas = Arrays.asList(
            new Pessoa("Renan"),
            new Pessoa("Zamboni")
    );

    public static Pessoa get(String nome) {
        return PessoaFixture.pessoas.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
}
