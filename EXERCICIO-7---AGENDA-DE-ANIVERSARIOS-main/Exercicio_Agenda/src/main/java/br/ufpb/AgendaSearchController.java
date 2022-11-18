package br.ufpb;

import java.awt.event.ActionEvent;
import java.util.Collection;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AgendaSearchController implements ActionListener {

    private AgendaInterface agenda;
    private JFrame janelaPrincipal;

    public AgendaSearchController(AgendaInterface agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dia = Integer
                .parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o dia do mês a pesquisar? [1-31]"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o mês a pesquisar? [1-12]"));
        Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);
        if (aniversariantes.size() > 0) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariantes Encontrados");
            for (Contato c : aniversariantes) {
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());

            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum aniversariante nesta data");
        }
    }

}
