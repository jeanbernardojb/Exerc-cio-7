package br.ufpb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AgendaRemoveController implements ActionListener {

    private AgendaInterface agenda;
    private JFrame janelaPrincipal;

    public AgendaRemoveController(AgendaInterface agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do aniversariante a remover?");
        boolean removeu = agenda.removeContato(nome);
        if (removeu) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariante removido com Sucesso!");

        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante não foi encontrado. " + "\nOperação não realizada.");
        }

    }
}