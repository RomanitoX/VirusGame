/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import virus.Controller.ControllerEntite;
import virus.Entite.VirusEnnemi;

/**
 *
 * @author RomanitoX
 */
public class Boucle {

    public static long time;

    public static void goTour() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Boucle.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ControllerEntite.virus.isReady && !ControllerEntite.virus.isDead && !ControllerEntite.virus.isStop) {
                    for (VirusEnnemi ennemi : ControllerEntite.ennemis) {
                        ControllerEntite.ennemi.getStade();
                    }
                    ControllerEntite.virus.getStade();
                    ControllerEntite.moveVirus();
                    ControllerEntite.moveBoule();
                    ControllerEntite.suiviEnnemi();
                    ControllerEntite.mangerEntite();
                }

            }
        }).start();
    }
}
