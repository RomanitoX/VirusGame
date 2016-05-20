/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virus.Controller;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author RomanitoX
 */
public class ControllerImage {

    public static Image background;

    public static void loadImages() {
        try {
            background = ImageIO.read(ControllerImage.class.getResourceAsStream("background.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ControllerImage.class.getName()).log(Level.SEVERE, null, ex);
        }
//        background = new ImageIcon("/src/image/background.jpg").getImage();
    }
}
