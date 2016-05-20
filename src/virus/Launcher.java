/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus;

import virus.Controller.ControllerEntite;
import virus.Controller.ControllerImage;
import virus.Controller.ControllerView;
import virus.Thread.Aleatoire;
import virus.Thread.Boucle;
import virus.Thread.Repaint;

/**
 *
 * @author RomanitoX
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerImage.loadImages();
        ControllerView.init();
        ControllerEntite.start();
        Boucle.goTour();
        new Thread(new Aleatoire()).start();
        new Thread(new Repaint()).start();
    }
}
