/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Entite;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author RomanitoX
 */
public class VirusPerso extends Entite {

    public boolean toUp = false;
    public boolean toDown = false;
    public boolean toLeft = false;
    public boolean toRight = false;
    public boolean toRightUp = false;
    public boolean toLeftUP = false;
    public boolean toRightDown = false;
    public boolean toLeftDown = false;
    public boolean isDead = true;
    public boolean isReady = false;
    public boolean isStop = false;
    public int compteur = 0;

    public Rectangle portee = new Rectangle(this.x - this.width / 2 - this.width / 2, this.y - this.height / 2 - this.height / 2, this.width * 3, this.height * 3);

    public VirusPerso(int taille, Color color, int x, int y, int width, int height) {
        super(taille, color, x, y, width, height);
    }

    public VirusPerso() {
    }

    @Override
    public String toString() {
        return Integer.toString(taille);
    }

    public Rectangle getPortee() {
        return portee;
    }

    public void setPortee(Rectangle portee) {
        this.portee = portee;
    }

}
