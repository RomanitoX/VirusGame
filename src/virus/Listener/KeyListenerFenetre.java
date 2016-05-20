/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import virus.Controller.ControllerEntite;
import static virus.Controller.ControllerEntite.virus;

/**
 *
 * @author RomanitoX
 */
public class KeyListenerFenetre implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                virus.toUp = true;
                virus.toDown = false;
                break;
            case KeyEvent.VK_DOWN:
                virus.toDown = true;
                virus.toUp = false;
                break;
            case KeyEvent.VK_LEFT:
                virus.toLeft = true;
                virus.toRight = false;
                break;
            case KeyEvent.VK_RIGHT:
                virus.toRight = true;
                virus.toLeft = false;
                break;
            case KeyEvent.VK_SPACE:
                if (virus.isDead && virus.isReady) {
                    ControllerEntite.reset();
                    virus.isDead = false;
                }
                break;
            case KeyEvent.VK_ENTER:
                if (!virus.isReady) {
                    virus.isReady = true;
                    virus.isDead = false;
                }
                break;
            case KeyEvent.VK_ESCAPE:
                ControllerEntite.virus.isStop = !ControllerEntite.virus.isStop;
                break;
            case KeyEvent.VK_ASTERISK:
                ControllerEntite.isDebug = !ControllerEntite.isDebug;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                virus.toUp = false;
                break;
            case KeyEvent.VK_DOWN:
                virus.toDown = false;
                break;
            case KeyEvent.VK_LEFT:
                virus.toLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                virus.toRight = false;
                break;
        }
    }
}
