package br.com.zup.zenity.domain.kudos;

import br.com.zup.zenity.PessoaFixture;
import br.com.zup.zenity.domain.Kudos;
import br.com.zup.zenity.domain.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

public class KudosTest {

    Pessoa renan = PessoaFixture.get("Renan");
    Pessoa xamba = PessoaFixture.get("Zamboni");

    @BeforeEach
    public void setup() {
        List<Kudos> kudosRenan = renan.getKudos();
        List<Kudos> kudosXamba = xamba.getKudos();

        if (kudosRenan != null) kudosRenan.clear();
        if (kudosXamba != null) kudosXamba.clear();
    }

    @Test
    public void enviarKudos() {
        Kudos otimoMentor = new Kudos(Kudos.Tipo.EXCELENTE_MENTOR, renan, new Date());
        renan.enviaKudos(otimoMentor, xamba);

        Assert.isNull(renan.getKudos(), "Renan não deveria ter kudos");

        Kudos kudosRecebido = xamba.getKudos().stream().findFirst().get();
        Assert.isTrue(kudosRecebido.getTipo().equals(Kudos.Tipo.EXCELENTE_MENTOR), "Xamba deveria ter ao menos um kudos");
        Assert.isTrue(kudosRecebido.getRemetente().equals(renan), "O remetente deveria ser Renan");
    }


    @Test
    public void enviarNovosKudos() {
        Kudos otimoMentor = new Kudos(Kudos.Tipo.EXCELENTE_MENTOR, renan, new Date());
        Kudos gratidao = new Kudos(Kudos.Tipo.GRATIDAO, renan, new Date());

        xamba.enviaKudos(gratidao, xamba);
        renan.enviaKudos(otimoMentor, xamba);

        List<Kudos> kudosRecebido = xamba.getKudos();
        Assert.isNull(renan.getKudos(), "Renan não deveria ter kudos");
        Assert.isTrue(kudosRecebido.size() == 2, "Xamba deveria ter dois Kudos");
    }
}
