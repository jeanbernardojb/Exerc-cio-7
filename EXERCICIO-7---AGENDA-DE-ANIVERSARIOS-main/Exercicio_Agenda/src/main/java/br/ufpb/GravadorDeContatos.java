package br.ufpb;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeContatos {

    private String fileName = "contatos.txt";

    public void gravaContatos(Collection<Contato> contatos) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Contato> contatosASalvar = new ArrayList<>(contatos);
            gravador.writeObject(contatosASalvar);
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }

    }

    public Collection<Contato> recuperaContatos() throws IOException, ClassNotFoundException {
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream(new FileInputStream(fileName));
            Collection<Contato> contatosLidos = (Collection<Contato>) leitor.readObject();
            return contatosLidos;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }
}