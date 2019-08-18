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
import main.TMenu;
import models.Jogador;

public class JogadorPerfilLogadoGUI extends JFrame {
    //ImageIcon iconeCreate;
    //ImageIcon iconeRetrieve;
    ImageIcon iconeUpdate;
    ImageIcon iconeDelete;
    ImageIcon iconeSave;
    ImageIcon iconeCancel;
    //ImageIcon iconeListar;

    //JButton btnCreate;
    //JButton btnRetrieve;
    JButton btnUpdate;
    JButton btnDelete;
    JButton btnSave;
    JButton btnCancel;
    //JButton btnList;

   JLabel labelUsername= new JLabel("Username");
   JLabel labelSenha= new JLabel("Senha");
   JLabel labelNome= new JLabel("Nome");
   JLabel labelSobrenome= new JLabel("Sobrenome");
   JLabel labelEmail= new JLabel("Email");
   JLabel labelPais= new JLabel("Pais");
   JLabel labelPontuacao= new JLabel("Pontos: ");
   JLabel labelPontos= new JLabel("0");
   JLabel labelParticipacao= new JLabel("Competições disputadas: ");
   JLabel labelEventos= new JLabel("Não disputou nenhuma competição ainda");
   JTextField textFieldUsername= new JTextField();
   JTextField textFieldSenha= new JTextField();
   JTextField textFieldNome= new JTextField();
   JTextField textFieldSobrenome= new JTextField();
   JTextField textFieldEmail= new JTextField();
   JTextField textFieldPais= new JTextField();
    JPanel aviso = new JPanel();
    JLabel labelAviso = new JLabel("");
    String acao = "";//variavel para facilitar insert e update
    JogadorControlaLista cl = new JogadorControlaLista();
    Jogador jogador = new Jogador();

private void atvBotoes(boolean u, boolean d) {
        btnUpdate.setEnabled(u);
        btnDelete.setEnabled(d);
    }

public void mostrarBotoes(boolean visivel) {
        btnUpdate.setVisible(visivel);
        btnDelete.setVisible(visivel);
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

public JogadorPerfilLogadoGUI(Jogador j) {

        //carregar imagens para os botões
        try {
            iconeUpdate = new ImageIcon(getClass().getResource("/icones/update.png"));
            iconeDelete = new ImageIcon(getClass().getResource("/icones/delete.png"));
            iconeSave = new ImageIcon(getClass().getResource("/icones/save.png"));
            iconeCancel = new ImageIcon(getClass().getResource("/icones/cancel.png"));
            
            btnUpdate = new JButton(iconeUpdate);
            btnDelete = new JButton(iconeDelete);
            btnSave = new JButton(iconeSave);
            btnCancel = new JButton(iconeCancel);
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

        atvBotoes(true, true);
        habilitarAtributos(false, false, false, false, false, false); 
        btnUpdate.setToolTipText("Alterar");
        btnDelete.setToolTipText("Excluir");
        btnSave.setToolTipText("Salvar");
        btnCancel.setToolTipText("Cancelar");
        JToolBar Toolbar1 = new JToolBar();
        Toolbar1.add(labelUsername);
        Toolbar1.add(textFieldUsername);
        Toolbar1.add(btnUpdate);
        Toolbar1.add(btnDelete);
        Toolbar1.add(btnSave);
        Toolbar1.add(btnCancel);
        btnSave.setVisible(false);
        btnCancel.setVisible(false);  //atributos
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(8, 2));
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
        centro.add(labelPontuacao);
        centro.add(labelPontos);
        centro.add(labelParticipacao);
        centro.add(labelEventos);
        aviso.add(labelAviso);
        aviso.setBackground(Color.yellow);
        cp.add(Toolbar1, BorderLayout.NORTH);
        cp.add(centro, BorderLayout.CENTER);
        cp.add(aviso, BorderLayout.SOUTH);
        
        textFieldUsername.setText(j.getUsername());
        textFieldSenha.setText(j.getSenha());
        textFieldNome.setText(j.getPerfil().getNome());
        textFieldSobrenome.setText(j.getPerfil().getSobrenome());
        textFieldEmail.setText(j.getPerfil().getEmail());
        textFieldPais.setText(j.getPerfil().getPais());
        
        textFieldUsername.requestFocus();
        textFieldUsername.selectAll();
        textFieldUsername.setBackground(Color.GREEN);
        labelAviso.setText("Escolha a operação.");

btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //System.out.println("update: " + cl.getLista());
                
                    jogador.setUsername(j.getUsername());
                    jogador = cl.retrieve(jogador);
                    Jogador original = jogador;
                if (jogador != null) {
                    //System.out.println("entrou update");
                    jogador.setSenha(textFieldSenha.getText());
                    jogador.getPerfil().setNome(textFieldNome.getText());
                    jogador.getPerfil().setSobrenome(textFieldSobrenome.getText());
                    jogador.getPerfil().setEmail(textFieldEmail.getText());
                    jogador.getPerfil().setPais(textFieldPais.getText());
                    cl.atualizar(original, jogador);
                    mostrarBotoes(true);
                    habilitarAtributos(false, false, false, false, false, false);
                    atvBotoes(true, true);
                    labelAviso.setText("Registro atualizado...");
                } else {
                    System.out.println("");
                    System.out.println("null");
                }
                    
            } 
        });
btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                zerarAtributos();
                textFieldUsername.setText(j.getUsername());
        textFieldSenha.setText(j.getSenha());
        textFieldNome.setText(j.getPerfil().getNome());
        textFieldSobrenome.setText(j.getPerfil().getSobrenome());
        textFieldEmail.setText(j.getPerfil().getEmail());
        textFieldPais.setText(j.getPerfil().getPais());
                atvBotoes(true, true);
                habilitarAtributos(false, false, false, false, false, false);
                mostrarBotoes(true);
            }
        });

btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                acao = "update";
                mostrarBotoes(false);
                habilitarAtributos(false, true, true, true, true, true);
            }
        });

btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,
                        "Confirma a exclusão do registro <ID = " + j.getUsername() + ">?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    labelAviso.setText("Registro excluído...");
                    jogador = cl.retrieve(j);
                    cl.excluir(jogador);
                    cl.serializaLista("JogadorPerfil.dat");
                    System.out.println("excluir: " + cl.getLista());
                    zerarAtributos();
                    JOptionPane.showMessageDialog(null, "Você não tem mais um registro nesse sistema. Você será direcionado "
                            + "para a tela principal.");
                    TMenu form = new TMenu(null, true);
                    form.setLocationRelativeTo(null);
                    dispose();
                    form.setVisible(true);
                }
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
