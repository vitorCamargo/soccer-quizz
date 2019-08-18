package views;

import controllers.JogadorControlaLista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import main.TLogin;
import models.Jogador;

public class JogadorPerfilGUI extends JFrame {
ImageIcon iconeCreate;
    ImageIcon iconeRetrieve;
    ImageIcon iconeUpdate;
    ImageIcon iconeDelete;
    ImageIcon iconeSave;
    ImageIcon iconeCancel;
    ImageIcon iconeListar;

    JButton btnCreate;
    JButton btnRetrieve;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnSave;
    JButton btnCancel;
    JButton btnList;

   JLabel labelUsername= new JLabel("Username");
   JLabel labelSenha= new JLabel("Senha");
   JLabel labelNome= new JLabel("Nome");
   JLabel labelSobrenome= new JLabel("Sobrenome");
   JLabel labelEmail= new JLabel("Email");
   JLabel labelPais= new JLabel("Pais");
   JTextField textFieldUsername= new JTextField("");
   JTextField textFieldSenha= new JTextField("");
   JTextField textFieldNome= new JTextField("");
   JTextField textFieldSobrenome= new JTextField("");
   JTextField textFieldEmail= new JTextField("");
   JTextField textFieldPais= new JTextField("");
JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String acao = "";//variavel para facilitar insert e update
    JogadorControlaLista cl = new JogadorControlaLista();
    Jogador jogador = new Jogador();

private void atvBotoes(boolean c) {
        btnCreate.setEnabled(c);
    }

public void mostrarBotoes(boolean visivel) {
        btnCreate.setVisible(visivel);
        //btnRetrieve.setVisible(visivel);
        //btnUpdate.setVisible(visivel);
        //btnDelete.setVisible(visivel);
        //btnList.setVisible(visivel);
        btnSave.setVisible(!visivel);
        btnCancel.setVisible(!visivel);
    }

   private void habilitarAtributos( boolean username, boolean senha, boolean nome, boolean sobrenome, boolean email, boolean pais){
if (username){
textFieldUsername.requestFocus();
textFieldUsername.selectAll();
}
textFieldUsername.setEnabled(username);
textFieldUsername.setEditable(username);
textFieldSenha.setEditable(senha);
textFieldNome.setEditable(nome);
textFieldSobrenome.setEditable(sobrenome);
textFieldEmail.setEditable(email);
textFieldPais.setEditable(pais);
}

public void zerarAtributos() {
textFieldSenha.setText("");
textFieldNome.setText("");
textFieldSobrenome.setText("");
textFieldEmail.setText("");
textFieldPais.setText("");
}

public JogadorPerfilGUI() {

        //carregar imagens para os botões
        try {
            iconeCreate = new ImageIcon(getClass().getResource("/icones/create.png"));
            //iconeRetrieve = new ImageIcon(getClass().getResource("/icones/retrieve.png"));
            iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
            iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
            iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
            iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
            iconeListar = new ImageIcon(getClass().getResource("/icones/list.png"));

            btnCreate = new JButton(iconeCreate);
            //btnRetrieve = new JButton(iconeRetrieve);
            //btnUpdate = new JButton(iconeUpdate);
            //btnDelete = new JButton(iconeDelete);
            btnSave = new JButton(iconeSave);
            btnCancel = new JButton(iconeCancel);
            //btnList = new JButton(iconeListar);
        } catch (Exception e) {
            System.out.println("Não achou alguma imagem para os botões, confira o caminho e se existe a package icones");
        }

        setTitle("Cadastro de JogadorPerfil");
        try {
            File arq = new File("JogadorPerfil.dat"); //tenta abrir o arquivo
            if (arq.exists()) { //se o arquivo já existe, abre e lê os dados
                cl.desSerializaLista("JogadorPerfil.dat");
            }
        } catch (Exception e) {
            System.out.println("arquivo não encontrado");
        }

        setSize(800, 600);//tamanho da janela
        setLayout(new BorderLayout());//informa qual gerenciador de layout será usado
        setBackground(Color.CYAN);//cor do fundo da janela
        Container cp = getContentPane();//container principal, para adicionar nele os outros componentes

        atvBotoes(true);
        habilitarAtributos(true, false, false, false, false, false); 
        btnCreate.setToolTipText("Inserir novo registro");
        //btnRetrieve.setToolTipText("Pesquisar por chave");
        //btnUpdate.setToolTipText("Alterar");
        //btnDelete.setToolTipText("Excluir");
        //btnList.setToolTipText("Listar todos");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(labelUsername);
        Toolbar1.add(textFieldUsername);
        //Toolbar1.add(btnRetrieve);
        Toolbar1.add(btnCreate);
        //Toolbar1.add(btnUpdate);
        //Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        //Toolbar1.add(btnList);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);  //atributos
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(6, 2));
        centro.add(labelUsername);
        centro.add(textFieldUsername);
        centro.add(labelSenha);
        centro.add(textFieldSenha);
        centro.add(labelNome);
        centro.add(textFieldNome);
        centro.add(labelSobrenome);
        centro.add(textFieldSobrenome);
        centro.add(labelEmail);
        centro.add(textFieldEmail);
        centro.add(labelPais);
        centro.add(textFieldPais);
        aviso.add(labelAviso);
        aviso.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(aviso, BorderLayout.SOUTH);
        textFieldUsername.requestFocus();
        textFieldUsername.selectAll();
        textFieldUsername.setBackground(Color.GREEN);
        labelAviso.setText("Digite um username e clique no +");


btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                jogador = new Jogador();
                jogador.setUsername(textFieldUsername.getText().trim());
                textFieldUsername.setText(textFieldUsername.getText().trim());//caso tenham sido digitados espaços
                if (textFieldUsername.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Deve ser informado um valor para esse campo");
                    textFieldUsername.requestFocus();
                    textFieldUsername.selectAll();
                } else {
                    jogador = cl.retrieve(jogador);
                    if (jogador != null) { //se encontrou na lista
                        JOptionPane.showMessageDialog(null, "Escolha outro username. Este já está cadastrado.");
                        labelAviso.setText("Escolha outro username.");
                        acao = "encontrou";
                    } else {
                        zerarAtributos();
                        habilitarAtributos(false, true, true, true, true, true);
                        textFieldSenha.requestFocus();
                        mostrarBotoes(false);
                        labelAviso.setText("Preencha os campos e clic [Salvar] ou clic [Cancelar]");
                        acao = "insert";
                    }
                }
                
            }
        });
btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                    jogador = new Jogador();
                    jogador.setUsername(textFieldUsername.getText());
                    jogador.setSenha(textFieldSenha.getText());
                    jogador.getPerfil().setNome(textFieldNome.getText());
                    jogador.getPerfil().setSobrenome(textFieldSobrenome.getText());
                    jogador.getPerfil().setEmail(textFieldEmail.getText());
                    jogador.getPerfil().setPais(textFieldPais.getText());
                    cl.inserir(jogador);
                    cl.serializaLista("JogadorPerfil.dat");
                    habilitarAtributos(true, false, false, false, false, false);
                    mostrarBotoes(true);
                    atvBotoes(false);
                    labelAviso.setText("Registro inserido...");
                    JogadorPerfilLogadoGUI form = new JogadorPerfilLogadoGUI(jogador);
                    dispose();
                    
                    form.setVisible(true);
                
            } 
        });
btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                zerarAtributos();
                atvBotoes(true);
                habilitarAtributos(true, false, false, false, false, false);
                mostrarBotoes(true);
            }
        });


textFieldUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldUsername.setBackground(Color.GREEN);
                if (acao != "encontrou") {
                    labelAviso.setText("Digite uma JogadorPerfil e clic [Pesquisar]");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                textFieldUsername.setBackground(Color.white);
            }
        });        textFieldUsername.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldUsername.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldUsername.setBackground(Color.white);
            }
        });

        textFieldSenha.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldSenha.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldSenha.setBackground(Color.white);
            }
        });

        textFieldNome.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldNome.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldNome.setBackground(Color.white);
            }
        });

        textFieldSobrenome.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldSobrenome.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldSobrenome.setBackground(Color.white);
            }
        });

        textFieldEmail.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldEmail.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldEmail.setBackground(Color.white);
            }
        });

        textFieldPais.addFocusListener(new FocusListener() { //ao receber o foco, fica verde
            @Override
            public void focusGained(FocusEvent fe) {
                textFieldPais.setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent fe) { //ao perder o foco, fica branco
                textFieldPais.setBackground(Color.white);
            }
        });

setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //antes de sair do sistema, grava os dados da lista em disco
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em disco
                cl.serializaLista("JogadorPerfil.dat");
                // Sai do sistema  
                System.exit(0);
            }
        });

        setVisible(true);//faz a janela ficar visível
        textFieldUsername.requestFocus();
}
}
