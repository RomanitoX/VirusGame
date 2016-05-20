/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import virus.Controller.ControllerEntite;

/**
 *
 * @author RomanitoX
 */
public class Aleatoire implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
            }
            ControllerEntite.getAlea();
//            ControllerEntite.ennemi.getVitesse();
        }
    }
}
