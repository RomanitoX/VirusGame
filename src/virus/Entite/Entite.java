/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Entite;

import java.awt.Color;
import java.awt.Rectangle;
import virus.Controller.ControllerEntite;

/**
 *
 * @author RomanitoX
 */
public class Entite extends Rectangle {

    public int taille;
    public Color color;
    public int vitesse;
    public int stade = 0;

    public Entite(int taille, Color color, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.taille = taille;
        this.color = ControllerEntite.getColor();
    }

    public Entite() {
    }

    public int getVitesse() {
//        vitesse = 250 / this.taille;
        if (this.stade == 0) {
            this.vitesse = 10;
        }
        if (this.stade == 1) {
            this.vitesse = 9;
        }
        if (this.stade == 2) {
            this.vitesse = 8;
        }
        if (this.stade == 3) {
            this.vitesse = 7;
        }
        if (this.stade == 4) {
            this.vitesse = 6;
        }
        if (this.stade == 5) {
            this.vitesse = 5;
        }
        if (this.stade == 6) {
            this.vitesse = 5;
        }
        if (this.stade == 7) {
            this.vitesse = 4;
        }
        if (this.stade == 8) {
            this.vitesse = 3;
        }
        if (this.stade == 9) {
            this.vitesse = 2;
        }
        if (this.stade == 10) {
            this.vitesse = 1;
        }
        return vitesse;
    }

    public int getStade() {
        if (this.taille >= 100) {
            this.stade = 1;
        }
        if (this.taille >= 200) {
            this.stade = 2;
        }
        if (this.taille >= 300) {
            this.stade = 3;
        }
        if (this.taille >= 400) {
            this.stade = 4;
        }
        if (this.taille >= 500) {
            this.stade = 5;
        }
        if (this.taille >= 600) {
            this.stade = 6;
        }
        if (this.taille >= 700) {
            this.stade = 7;
        }
        if (this.taille >= 800) {
            this.stade = 8;
        }
        if (this.taille >= 900) {
            this.stade = 9;
        }
        if (this.taille >= 1000) {
            this.stade = 10;
        }
        return stade;
    }

    public void setStade(int stade) {
        this.stade = stade;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
