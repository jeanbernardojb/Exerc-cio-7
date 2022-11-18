package br.ufpb;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class AgendaGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon imgAniversario = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"aniversarioImg2.jpg");
    ImageIcon addImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"adicionarImg.png");
    ImageIcon pesqImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"pesquisarImg.png");
    ImageIcon removeImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"removerImg.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    AgendaInterface agenda = new MinhaAgenda();
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeContatos gravador = new GravadorDeContatos();

    public AgendaGUI() {

        File f = new File ("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"addImg.jpg");
        System.out.println(f.exists());
        System.out.println(f.getAbsolutePath());

        setTitle("Agenda de Aniversários");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        Collection<Contato> contatos = null;
        try {
            contatos = gravador.recuperaContatos();
            for (Contato c: contatos){
                this.agenda.cadastraContato(c.getNome(), c.getDiaAniversario(), c.getMesAniversario());
            }
            JOptionPane.showMessageDialog(null, "Contatos recuperados com sucesso");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Contatos não recuperados. Erro: "+e.getMessage());
            e.printStackTrace();
        }

        linha1 = new JLabel("Minha Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Arial", Font.BOLD, 22));
        linha2 = new JLabel(imgAniversario, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));
        botaoPesquisar = new JButton("Pesquisar", pesqImg);
        botaoPesquisar.addActionListener(new AgendaSearchController(agenda, this));
        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));

        setLayout(new GridLayout(3, 2));
        add(linha1);
        add(botaoAdicionar);
        add(linha2);
        add(botaoPesquisar);
        add(new JLabel());
        add(botaoRemover);

        JMenu menuOperacoes = new JMenu("Operações com Aniversariantes");
        JMenuItem menuCadastrarAniversariante = new JMenuItem("Cadastrar Aniversariante");
        menuOperacoes.add(menuCadastrarAniversariante);
        menuCadastrarAniversariante.addActionListener(new AgendaAddController(agenda, this));
        
        JMenuItem menuPesquisarAniversariante = new JMenuItem("Pesquisar Aniversariante");
        menuOperacoes.add(menuPesquisarAniversariante);
        menuPesquisarAniversariante.addActionListener(new AgendaSearchController(agenda, this));

        JMenuItem menuRemoverAniversariante = new JMenuItem("Remover Aniversariante");
        menuOperacoes.add(menuRemoverAniversariante);
        menuRemoverAniversariante.addActionListener(new AgendaRemoveController(agenda, this));

        barraDeMenu.add(menuOperacoes);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarDados = new JMenuItem("Salvar dados");
        menuSalvar.add(menuSalvarDados);
        menuSalvarDados.addActionListener(new AgendaSaveController(agenda, this, gravador));
       
        barraDeMenu.add(menuSalvar);

        setJMenuBar(barraDeMenu);
        File arquivo = new File(".");
        System.out.println("===>"+arquivo.getAbsolutePath());
    
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
