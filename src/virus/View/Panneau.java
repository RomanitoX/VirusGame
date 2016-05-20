/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;
import virus.Controller.ControllerEntite;
import static virus.Controller.ControllerEntite.virus;
import virus.Controller.ControllerImage;
import virus.Entite.Boule;
import virus.Entite.VirusEnnemi;

/**
 *
 * @author RomanitoX
 */
public class Panneau extends JPanel {

    public Panneau() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(Color.white);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(ControllerImage.background, 0, 0, 2048, 1536, this);
        if (!ControllerEntite.virus.isReady) {
            // showEntitys(g2);
            showStartScreen(g2);
        }
        if (ControllerEntite.virus.isStop && !ControllerEntite.virus.isDead) {
            showEntitys(g2);
            showPauseScreen(g2);
        }
        if (ControllerEntite.virus.isDead && ControllerEntite.virus.isReady) {
            showEntitys(g2);
            showDeadScreen(g2);
        }
        if (!ControllerEntite.virus.isDead && ControllerEntite.virus.isReady) {
            showEntitys(g2);
            showVirus(g2);
        }
        if (ControllerEntite.isDebug) {
            showDebug(g2);
        }

    }

    private void showVirus(Graphics2D g) {
        g.setColor(virus.color);
        g.fillOval(virus.x - (virus.width / 2) / 2, virus.y - (virus.height / 2) / 2, virus.width + virus.width / 2, virus.height + virus.height / 2);
        g.setColor(Color.black);
        g.drawOval(virus.x - (virus.width / 2) / 2, virus.y - (virus.height / 2) / 2, virus.width + virus.width / 2, virus.height + virus.height / 2);
        g.setColor(Color.black);
        g.drawString(virus.toString(), virus.x + (virus.width / 2) - 5, virus.y + (virus.height / 2) + 5);
    }

    private void showStartScreen(Graphics2D g2d) {
        Font big = new Font("Press Start 2P", Font.BOLD, 72);
        Font small = new Font("Press Start 2P", Font.BOLD, 36);
        g2d.setColor(Color.white);
        String s = "Virus Hunter";
        String reset = "Appuyer sur entrer pour jouer";
        g2d.setColor(Color.red);
        g2d.setFont(big);
        g2d.drawString(s, 375, 250);
        g2d.setFont(small);
        g2d.setColor(Color.orange);
        g2d.drawString(reset, 300, 500);
        g2d.setColor(Color.GREEN);
    }

    private void showPauseScreen(Graphics2D g2d) {
        g2d.setColor(Color.white);
        Font big = new Font("Press Start 2P", Font.BOLD, 72);
        String s = "Virus Hunter";
        String pause = "Jeu en pause";
        Font small = new Font("Press Start 2P", Font.BOLD, 36);
        g2d.setColor(Color.red);
        g2d.setFont(big);
        g2d.drawString(s, 350, 250);
        g2d.setColor(Color.orange);
        g2d.drawString(pause, 350, 500);
    }

    private void showDeadScreen(Graphics2D g2d) {
        g2d.setColor(Color.white);
        String s = "GAME OVER!";
        String score = " Score = " + ControllerEntite.virus.getTaille();
        String reset = "Appuyer sur espace pour rejouer";
        Font small = new Font("Press Start 2P", Font.BOLD, 36);
        Font big = new Font("Press Start 2P", Font.BOLD, 72);
        g2d.setColor(Color.BLUE);
        g2d.setFont(big);
        g2d.drawString(s, 450, 200);
        g2d.setColor(Color.orange);
        g2d.setFont(small);
        g2d.drawString(score, 550, 350);
        g2d.setColor(Color.magenta);
        g2d.drawString(reset, 220, 600);
    }

    private void showEntitys(Graphics2D g) {
        Font point = new Font(("Arimo"), Font.BOLD, 10);
        g.setFont(point);
        for (VirusEnnemi ennemi1 : (ArrayList<VirusEnnemi>) ControllerEntite.getEnnemis().clone()) {
            g.setColor(ennemi1.color);
            g.fillOval(ennemi1.x - (ennemi1.width / 2) / 2, ennemi1.y - (ennemi1.width / 2) / 2, ennemi1.width + ennemi1.width / 2, ennemi1.height + ennemi1.height / 2);
            g.setColor(Color.black);
            g.drawOval(ennemi1.x - (ennemi1.width / 2) / 2, ennemi1.y - (ennemi1.width / 2) / 2, ennemi1.width + ennemi1.width / 2, ennemi1.height + ennemi1.width / 2);
            g.drawString(ennemi1.toString(), (ennemi1.x + ennemi1.width / 2) - 7, (ennemi1.y + ennemi1.height / 2) + 5);

        }
        for (Boule boule1 : (ArrayList<Boule>) ControllerEntite.getBoules().clone()) {
            g.setColor(boule1.color);
            g.fillOval(boule1.x, boule1.y, boule1.width, boule1.height);
        }
    }

    private void showDebug(Graphics2D g) {
        g.setColor(Color.BLACK);
        for (VirusEnnemi ennemi1 : (ArrayList<VirusEnnemi>) ControllerEntite.getEnnemis().clone()) {
            //Portée des ennemies
            g.drawRect(ennemi1.getPortee().x, ennemi1.getPortee().y, ennemi1.getPortee().width, ennemi1.getPortee().height);
            //Portée du virus
            g.drawRect(virus.getPortee().x, virus.getPortee().y, virus.getPortee().width, virus.getPortee().height);
            //HitBox du virus controllée
            g.drawRect(virus.x, virus.y, virus.width, virus.height);
            g.drawRect(ennemi1.x, ennemi1.y, ennemi1.width, ennemi1.height);
        }

    }
}
