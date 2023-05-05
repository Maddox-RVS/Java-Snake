package Utils;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Game.Constants;

public class Sprite {
    private Image sprite;
    private BufferedImage buffImage;
    private JPanel panel;
    private int x, y, width, height;
    private String directory;
    private double rotation;

    public Sprite(String imgFileName, int x, int y) {
        this.x = x;
        this.y = y;
        rotation = 0.0;

        String dir = "";
        char[] dirCharArr = Constants.content.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            dir += letter=='\\'?"/":letter;
        directory = dir + "/src/Content/" + imgFileName;
        
        loadBufferedImage();
        refreshPanel();
    }

    public void setRotation(double degrees) {
        rotation = degrees;
        refreshPanel();
    }
    public double getRotation() { return rotation; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D getPosition() { return new Vector2D(x, y); }

    public int getWidth() { return buffImage.getWidth(); }
    public int getHeight() { return  buffImage.getHeight(); }

    public void loadBufferedImage() { 
        try {
            buffImage = ImageIO.read(new File(directory));
        } catch (Exception e) {
            System.out.println("Failed to load -> " + directory);
        }
    }

    public void refreshPanel() {
        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(buffImage.getWidth(), buffImage.getHeight());
            }
    
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.rotate(Math.toRadians(rotation), x+buffImage.getWidth()/2, y+buffImage.getHeight()/2);
                g2.drawImage(buffImage, x, y, null);
            }
        };
    }

    public JPanel get() { return panel; }
}
