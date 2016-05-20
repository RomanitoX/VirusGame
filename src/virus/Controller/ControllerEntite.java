/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Controller;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import virus.Entite.Boule;
import virus.Entite.Entite;
import virus.Entite.VirusEnnemi;
import virus.Entite.VirusPerso;

/**
 *
 * @author RomanitoX
 */
public class ControllerEntite {

    public static ArrayList<VirusEnnemi> ennemis = new ArrayList<>();
    public static ArrayList<Boule> boules = new ArrayList<>();
    public static Color colorAlea;
    public static Entite entite;
    public static int xAlea;
    public static int aleatoire;
    public static int yAlea;
    public static int xBouleAlea;
    public static int yBouleAlea;
    public static int wHAlea;
    public static VirusPerso virus;
    public static VirusEnnemi ennemi;
    public static Boule boule;
    public static boolean isDebug = false;

    public static Color getColor() {
        colorAlea = new Color((int) (Math.random() * 0x1000000));
        return colorAlea;
    }

    public static int setPosX() {
        xAlea = (int) (Math.random() * 10000);
        return xAlea;
    }

    public static int setPosY() {
        yAlea = (int) (Math.random() * 10000);
        return yAlea;
    }

    public static int setRect() {
        wHAlea = (int) (Math.random() * 25 + 5);
        return wHAlea;
    }

    public static ArrayList<VirusEnnemi> getEnnemis() {
        return ennemis;
    }

    public static ArrayList<Boule> getBoules() {
        return boules;
    }

    public static int getAlea() {
        aleatoire = (int) (Math.random() * 3);
        return aleatoire;
    }

    public static void start() {
        initBoule();
        initPerso();
        initEnnemi();
    }

    public static void initPerso() {
        virus = new VirusPerso(20, getColor(), (ControllerView.panneau.getWidth() - 25) / 2 + 6, (ControllerView.panneau.getHeight() - 25) / 2 - 5, 10, 10);
    }

    public static void initEnnemi() {
        for (int i = 0; i < 500; i++) {
            setRect();
            ennemi = new VirusEnnemi(wHAlea + wHAlea, getColor(), setPosX(), setPosY(), wHAlea, wHAlea);
            ennemis.add(ennemi);
            ennemi.getStade();
            ennemi.getVitesse();
        }
    }

    public static void initBoule() {
        for (int i = 0; i < 2500; i++) {
            boule = new Boule(2, getColor(), setPosX(), setPosY(), 25, 25);
            boules.add(boule);
        }
    }

    public static void suiviEnnemi() {
        for (VirusEnnemi ennemi1 : (ArrayList<VirusEnnemi>) ennemis.clone()) {
            for (VirusEnnemi current : ennemis) {
                if (!ennemi1.equals(current)) {
                    if (ennemi1.intersects(current.getPortee())) {
                        if (ennemi1.taille > current.taille) {
                            if (ennemi1.y < current.y) {
                                ennemi1.y += ennemi1.getVitesse();
                                ennemi1.getPortee().y += ennemi1.getVitesse();
                            }
                            if (ennemi1.y > current.y) {
                                ennemi1.y -= ennemi1.getVitesse();
                                ennemi1.getPortee().y -= ennemi1.getVitesse();
                            }
                            if (ennemi1.x < current.x) {
                                ennemi1.x += ennemi1.getVitesse();
                                ennemi1.getPortee().x -= ennemi1.getVitesse();
                            }
                            if (ennemi1.x > current.x) {
                                ennemi1.x -= ennemi1.getVitesse();
                                ennemi1.getPortee().x -= ennemi1.getVitesse();
                            }
                        }
                        if (ennemi1.taille > current.taille) {
                            if (ennemi1.y > current.y) {
                                ennemi1.y += ennemi1.getVitesse();
                                ennemi1.getPortee().y += ennemi1.getVitesse();
                            }
                            if (ennemi1.y < current.y) {
                                ennemi1.y -= ennemi1.getVitesse();
                                ennemi1.getPortee().y -= ennemi1.getVitesse();
                            }
                            if (ennemi1.x > current.x) {
                                ennemi1.x += ennemi1.getVitesse();
                                ennemi1.getPortee().x -= ennemi1.getVitesse();
                            }
                            if (ennemi1.x < current.x) {
                                ennemi1.x -= ennemi1.getVitesse();
                                ennemi1.getPortee().x -= ennemi1.getVitesse();
                            }

                        }
                    }
                }
            }
            if (aleatoire == 0) {
                ennemi1.x -= ennemi1.getVitesse();
                ennemi1.getPortee().x -= ennemi1.getVitesse();
                virus.compteur = 0;
            }
            if (aleatoire == 1) {
                ennemi1.x += ennemi1.getVitesse();
                ennemi1.getPortee().x += ennemi1.getVitesse();
                virus.compteur = 0;
            }
            if (aleatoire == 2) {
                ennemi1.y -= ennemi1.getVitesse();
                ennemi1.getPortee().y -= ennemi1.getVitesse();
                virus.compteur = 0;
            }
            if (aleatoire == 3) {
                ennemi1.y += ennemi1.getVitesse();
                ennemi1.getPortee().y += ennemi1.getVitesse();
                virus.compteur = 0;
            }
            for (Boule boule1 : (ArrayList<Boule>) boules.clone()) {
                if (boule1.intersects(ennemi1.getPortee())) {
                    if (boule1.y > ennemi1.y) {
                        ennemi1.y += ennemi1.getVitesse();
                        ennemi1.getPortee().y += ennemi1.getVitesse();
                    }
                    if (boule1.y < ennemi1.y) {
                        ennemi1.y -= ennemi1.getVitesse();
                        ennemi1.getPortee().y -= ennemi1.getVitesse();
                    }
                    if (boule1.x < ennemi1.x) {
                        ennemi1.x -= ennemi1.getVitesse();
                        ennemi1.getPortee().x -= ennemi1.getVitesse();
                    }
                    if (boule1.x > ennemi1.x) {
                        ennemi1.x += ennemi1.getVitesse();
                        ennemi1.getPortee().x += ennemi1.getVitesse();
                    }
                }
            }
        }
    }

    public static void moveVirus() {
        if (virus.isReady && !virus.isDead) {
            for (VirusEnnemi ennemi1 : (ArrayList<VirusEnnemi>) ennemis.clone()) {

                if (virus.toUp) {
                    ennemi1.y += virus.getVitesse();
                    ennemi1.getPortee().y += virus.getVitesse();
                    System.out.println(virus.getVitesse());
                    System.out.println(virus.getStade());
                } else if (virus.toDown) {
                    ennemi1.y -= virus.getVitesse();
                    ennemi1.getPortee().y -= virus.getVitesse();
                }
                if (virus.toLeft) {
                    ennemi1.x += virus.getVitesse();
                    ennemi1.getPortee().x += virus.getVitesse();
                } else if (virus.toRight) {
                    ennemi1.x -= virus.getVitesse();
                    ennemi1.getPortee().x -= virus.getVitesse();
                }
                if (virus.intersects(ennemi1.getPortee())) {
                    if (virus.taille <= ennemi1.taille) {
                        if (virus.y > ennemi1.y) {
                            ennemi1.y += ennemi1.getVitesse();
                            ennemi1.getPortee().y += ennemi1.getVitesse();
                        }
                        if (virus.y < ennemi1.y) {
                            ennemi1.y -= ennemi1.getVitesse();
                            ennemi1.getPortee().y -= ennemi1.getVitesse();
                        }
                        if (virus.x < ennemi1.x) {
                            ennemi1.x -= ennemi1.getVitesse();
                            ennemi1.getPortee().x -= ennemi1.getVitesse();
                        }
                        if (virus.x > ennemi1.x) {
                            ennemi1.x += ennemi1.getVitesse();
                            ennemi1.getPortee().x += ennemi1.getVitesse();
                        }
                    }
                }
//                if (virus.intersects(ennemi1.getPortee())) {
//                    if (virus.taille >= ennemi1.taille) {
//                        if (virus.y < ennemi1.y) {
//                            ennemi1.y += ennemi1.getVitesse();
//                            ennemi1.getPortee().y += ennemi1.getVitesse();
//                        }
//                        if (virus.y > ennemi1.y) {
//                            ennemi1.y -= ennemi1.getVitesse();
//                            ennemi1.getPortee().y -= ennemi1.getVitesse();
//                        }
//                        if (virus.x > ennemi1.x) {
//                            ennemi1.x -= ennemi1.getVitesse();
//                            ennemi1.getPortee().x -= ennemi1.getVitesse();
//                        }
//                        if (virus.x < ennemi1.x) {
//                            ennemi1.x += ennemi1.getVitesse();
//                            ennemi1.getPortee().x += ennemi1.getVitesse();
//                        }
//                    }
//                }
            }
        }
    }

    public static void moveBoule() {
        if (!virus.isDead && virus.isReady) {
            for (Boule boule1 : boules) {
                if (virus.toUp) {
                    boule1.y += virus.getVitesse();
                } else if (virus.toDown) {
                    boule1.y -= virus.getVitesse();
                }
                if (virus.toLeft) {
                    boule1.x += virus.getVitesse();
                } else if (virus.toRight) {
                    boule1.x -= virus.getVitesse();
                }
            }
        }
    }

    public static void mangerEntite() {
        if (!virus.isDead && virus.isReady) {
            for (VirusEnnemi ennemi1 : (ArrayList<VirusEnnemi>) ennemis.clone()) {
                for (int i = 0; i < ennemis.size(); i++) {
                    VirusEnnemi current = ennemis.get(i);
                    if (!ennemi1.equals(current)) {
                        if (ennemi1.intersects(current)) {
                            if (ennemi1.getTaille() < current.getTaille()) {
                                current.setTaille((ennemi1.getTaille() + current.getTaille()));
                                current.width = current.getTaille() / 2;
                                current.height = current.getTaille() / 2;
                                ennemi1.setPortee(new Rectangle(ennemi1.x - ennemi1.width * 10 + ennemi1.width / 2, ennemi1.y - ennemi1.height * 10 + ennemi1.height / 2, ennemi1.width * 20, ennemi1.height * 20));
                                ennemis.remove(ennemi1);
                            }
                        }
                    }
                }
                if (virus.intersects(ennemi1)) {
                    if (ennemi1.getTaille() > virus.getTaille()) {
                        virus.isDead = true;
                    }
                    if (ennemi1.getTaille() < virus.getTaille()) {
                        virus.x = (int) ((ControllerView.panneau.getWidth() - virus.getWidth()) / 2);
                        virus.y = (int) ((ControllerView.panneau.getHeight() - virus.getHeight()) / 2);
                        virus.setTaille(virus.getTaille() + ennemi1.getTaille());
                        virus.width = virus.getTaille() / 2;
                        virus.height = virus.getTaille() / 2;
                        ennemis.remove(ennemi1);
                    }

                }
                for (Boule boule1 : (ArrayList<Boule>) boules.clone()) {
                    if (virus.intersects(boule1)) {
                        virus.x = (int) ((ControllerView.panneau.getWidth() - virus.getWidth()) / 2);
                        virus.y = (int) ((ControllerView.panneau.getHeight() - virus.getHeight()) / 2);
                        virus.setTaille(virus.getTaille() + boule1.getTaille());
                        virus.width = virus.getTaille() / 2;
                        virus.height = virus.getTaille() / 2;
                        boules.remove(boule1);
                    }
                    if (ennemi1.intersects(boule1)) {
                        ennemi1.setTaille(ennemi1.getTaille() + boule1.getTaille());
                        ennemi1.width = ennemi1.getTaille() / 2;
                        ennemi1.height = ennemi1.getTaille() / 2;
                        ennemi1.setPortee(new Rectangle(ennemi1.x - ennemi1.width * 10 + ennemi1.width / 2, ennemi1.y - ennemi1.height * 10 + ennemi1.height / 2, ennemi1.width * 20, ennemi1.height * 20));
                        boules.remove(boule1);
                    }
                }
            }
        }
    }

    public static void reset() {
        ennemis.removeAll(ennemis);
        boules.removeAll(boules);
        initEnnemi();
        initPerso();
        initBoule();
        virus.isReady = true;
    }

    public ControllerEntite() {
    }

}
