package br.ufpb;

import java.io.Serializable;

public class Contato implements Serializable {

    private String nome;
    private int dia;
    private int mes;

    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
    }

    public Contato(){
        this("", 0, 0);
    }

    @Override
    public String toString() {
        return "Aniversariante [ Nome = " + this.nome + ", Dia do aniversário = " + this.dia + ", Mês do aniversário = "
                + this.mes + " ]";
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getDiaAniversario() {
        return this.dia;
    }

    public void setDiaAniversario(int novoDia) {
        this.dia = novoDia;
    }

    public int getMesAniversario() {
        return this.mes;
    }

    public void setMesAniversario(int novoMes) {
        this.mes = novoMes;
    }

}
