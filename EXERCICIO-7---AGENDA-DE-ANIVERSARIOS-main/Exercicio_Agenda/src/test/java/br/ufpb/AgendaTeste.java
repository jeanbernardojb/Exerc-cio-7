package br.ufpb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AgendaTeste {

    @Test
    public void testaConstrutorAgenda() {
        MinhaAgenda agenda = new MinhaAgenda();
        assertTrue(agenda.getContatos().size() == 0);
    }

    @Test
    public void testaCadastrarContatoEPesquisarAnivesariantesData() {
        MinhaAgenda agenda = new MinhaAgenda();
        assertTrue(agenda.getContatos().size() == 0);
        assertEquals(0, agenda.pesquisaAniversariantes(5, 10).size());
        agenda.cadastraContato("Ana", 5, 10);
        assertEquals(1, agenda.pesquisaAniversariantes(5, 10).size());
        agenda.cadastraContato("Maria", 5, 10);
        assertEquals(2, agenda.pesquisaAniversariantes(5, 10).size());
        assertEquals(0, agenda.pesquisaAniversariantes(1, 1).size());
        assertEquals(2, agenda.getContatos().size());
    }

    @Test
    public void testaRemoverAniversariante() {
        MinhaAgenda agenda = new MinhaAgenda();
        boolean cadastro = agenda.cadastraContato("José", 7, 10);
        assertTrue(cadastro);
        assertTrue(agenda.getContatos().size() == 1);
        assertEquals(1, agenda.pesquisaAniversariantes(7, 10).size());
        boolean remocao = agenda.removeContato("José");
        assertTrue(remocao);
        assertTrue(agenda.getContatos().size() == 0);
        assertEquals(0, agenda.pesquisaAniversariantes(7, 10).size());

    }
}