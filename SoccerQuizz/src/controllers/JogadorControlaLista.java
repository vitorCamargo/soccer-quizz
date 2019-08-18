package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import models.Jogador;

public class JogadorControlaLista implements java.io.Serializable {
private List<Jogador> lista= new ArrayList<Jogador>();
public void inserir(Jogador jogador) {
 lista.add(jogador);
 }
public Jogador retrieve(Jogador jogador) {
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                String chaveNaLista = lista.get(i).getUsername();
                String chaveProcurada = jogador.getUsername();
if (chaveNaLista.equals(chaveProcurada)) {
                    return lista.get(i);
                }
            }
        }
        return null;//não achou na lista
        }

public Jogador retrieve(String username) {
    //System.out.println("oi" + username);
        if (lista.size() > 0) {
            //System.out.println("oi" + lista);
            //System.out.println("oi" + username);
            for (int i = 0; i < lista.size(); i++) {
                String chaveNaLista = lista.get(i).getUsername();
                String chaveProcurada = username;
                if (chaveNaLista.equals(chaveProcurada)) {
                    return lista.get(i);
                }
            }
        }
        return null;//não achou na lista
        }
public void atualizar(Jogador jogadorProcurado, Jogador jogadorAlterado) {
        lista.set(lista.indexOf(jogadorProcurado), jogadorAlterado);
    }
public void excluir(Jogador jogador) {
        lista.remove(jogador);
    }
public void listarTodos() {
        if (lista.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for  (int i= 0; i<lista.size(); i++){
                   Jogador jogador= lista.get(i);
                System.out.println( i + jogador.toString());
}
}
}
public void desSerializaLista(String arquivo) {
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        lista.clear();
        try {
            //arquivo onde estao os dados serializados
            arqLeitura = new FileInputStream(arquivo);

            //objeto que vai ler os dados do arquivo
            in = new ObjectInputStream(arqLeitura);

            //recupera os dados
            lista = (ArrayList<Jogador>) in.readObject();

        } catch (ClassNotFoundException ex) {
            System.out.println("erro 1: " + ex);
        } catch (IOException ex) {
            System.out.println("erro 2: " + ex);
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                System.out.println("erro 3: " + ex);
            }
        }

    }
public void serializaLista(String arquivo) {

        FileOutputStream arq = null;
        ObjectOutputStream out = null;
        try {
            //arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

            //objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);
            out.writeObject(lista);
        } catch (IOException ex) {
            System.out.println("erro: " + ex);
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
            }
        }
    }
public List<Jogador> getLista() {
        return lista;
    }
}
