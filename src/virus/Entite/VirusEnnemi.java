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
public class VirusEnnemi extends Entite {

    public Rectangle portee = new Rectangle(this.x - this.width * 10 + this.width / 2, this.y - this.height * 10 + this.height / 2, this.width * 20, this.height * 20);

    public VirusEnnemi(int taille, Color color, int x, int y, int width, int height) {
        super(taille, color, x, y, width, height);
    }

    public VirusEnnemi() {
    }

    public Rectangle getPortee() {
        return portee;
    }

    public void setPortee(Rectangle portee) {
        this.portee = portee;
    }

    @Override
    public String toString() {
        return Integer.toString(taille);
    }
}
