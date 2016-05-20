/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import virus.Listener.KeyListenerFenetre;
import virus.View.Fenetre;
import virus.View.Panneau;

/**
 *
 * @author RomanitoX
 */
public class ControllerView {

    public static Fenetre fenetre;
    public static Panneau panneau;

    public static void init() {
        fenetre = new Fenetre();
        fenetre.setTitle("Virus V1.0");
        fenetre.addKeyListener(new KeyListenerFenetre());
        panneau = new Panneau();
        fenetre.jPanelPrincipal.add(panneau, BorderLayout.CENTER);
        fenetre.setSize(new Dimension(1600, 900));
        fenetre.setLocationRelativeTo(null);
        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenetre.setResizable(false);
        fenetre.setVisible(true);
    }
}
