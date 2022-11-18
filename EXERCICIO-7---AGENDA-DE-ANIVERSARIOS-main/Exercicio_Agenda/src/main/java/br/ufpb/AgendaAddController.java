package br.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgendaAddController implements ActionListener {
     private AgendaInterface agenda;
     private JFrame janelaPrincipal;
     public AgendaAddController(AgendaInterface agenda, JFrame janela) {
         this.agenda = agenda;
         this.janelaPrincipal = janela;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do Aniversariante?");

        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o dia do mês em que "+ nome + " nasceu? [1-31]"));

        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o mês em que "+nome+" nasceu? [1-12]"));

        boolean cadastrou = agenda.cadastraContato(nome, dia, mes);
        if(cadastrou) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariante Cadastrado com Sucesso!");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariante não foi Cadastrado! \nVerifique se já existia.");
        }
    }
    

}
