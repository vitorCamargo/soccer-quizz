/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.Jogador;
import views.JogadorPerfiCompletoGUI;

/**
 *
 * @author thais
 */
public class SoccerQuizz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Jogador jogador = new Jogador();
//        JogadorPerfiCompletoGUI jogadorPerfilCompletoGUI = new JogadorPerfiCompletoGUI(jogador);
        TMenu form = new TMenu(null, true);
        form.setLocationRelativeTo(null);
        form.setVisible(true); 
    }
    
}
