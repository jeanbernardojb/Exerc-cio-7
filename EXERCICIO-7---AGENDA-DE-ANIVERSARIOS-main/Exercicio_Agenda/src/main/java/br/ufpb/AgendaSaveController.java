package br.ufpb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgendaSaveController implements ActionListener {
    private AgendaInterface agenda;
    private GravadorDeContatos gravador;
    private JFrame janelaPrincipal;

    public AgendaSaveController(AgendaInterface agenda, JFrame janela, GravadorDeContatos gravador) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gravador.gravaContatos(agenda.getContatos());
            JOptionPane.showMessageDialog(janelaPrincipal, "Contatos salvos com sucesso");
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Contatos não salvos. Erro: " + ioException.getMessage());
            ioException.printStackTrace();
        }
    }
}