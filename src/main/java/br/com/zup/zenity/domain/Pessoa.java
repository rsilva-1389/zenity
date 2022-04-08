package br.com.zup.zenity.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pessoa {

    private final String nome;
    private List<Kudos> kudos;
    private List<Personas> personas;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public void enviaKudos(Kudos kudos, Pessoa destinatario) {
        this.enviar(kudos, destinatario);
    }

    public void enviaPersona(Personas persona, Pessoa destinatario) {
        this.enviar(persona, destinatario);
    }

    /**
     * @param obj          instância do objeto <T> que será enviado para o destinatário
     * @param destinatario Pessoa que irá receber o objeto, por convenção, o nome declardo da classe deve ser o mesmo nome da lista declarada na entidade Pessoa
     * @param <T>
     */
    private <T> void enviar(T obj, Pessoa destinatario) {
        String objEnviado = obj.getClass().getSimpleName().toLowerCase();
        try {
            Field campo = Pessoa.class.getDeclaredField(objEnviado);
            Collection<T> collection = (Collection<T>) campo.get(destinatario);

            if (collection == null) {
                collection = new ArrayList<T>();
                collection.add(obj);

                campo.set(destinatario, collection);
                return;
            }

            collection.add(obj);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(String.format("Erro ao enviar %s para destinatario %s", obj.getClass().getSimpleName(), destinatario.getNome()), e);
        }
    }

    public String getNome() {
        return this.nome;
    }

    public List<Kudos> getKudos() {
        return this.kudos;
    }
}
