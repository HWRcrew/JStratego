/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jstratego.gui.game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class BackgroundPanelStart extends JPanel {

    Image img;

    public BackgroundPanelStart() {
        loadImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int imagewidth = img.getWidth(this);
        int imageheight = img.getHeight(this);
        int x = (width - imagewidth) / 2;
        int y = (height - imageheight) / 2;
        g.drawImage(img, x, y, this);
    }

    public void loadImage() {
        String filename = "/jstratego/gui/img/start.png";
        try {
            URL url = getClass().getResource(filename);
            img = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

