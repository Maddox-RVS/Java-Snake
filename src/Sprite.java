import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sprite extends JPanel {
    private Image sprite;
    private int width, height;
    private String directory;
    private double rotation;

    public Sprite(String imgFileName, int width, int height) {
        this.width = width;
        this.height = height;
        rotation = 0.0;

        String dir = "";
        char[] dirCharArr = Constants.content.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            dir += letter=='\\'?"/":letter;
        directory = dir + "/src/Content/" + imgFileName;
        sprite = new ImageIcon(directory).getImage();
    }

    public void rotate() {
        BufferedImage rotatedImage = new BufferedImage(sprite.getWidth(null), sprite.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Get a Graphics2D object from the new BufferedImage
        Graphics2D graphics2d = rotatedImage.createGraphics();
        // Calculate the center point of the image
        int centerX = sprite.getWidth(null)/2;
        int centerY = sprite.getHeight(null)/2;
        // Rotate the graphics context around the center point by 90 degrees
        graphics2d.rotate(Math.toRadians(45), centerX, centerY);
        // Draw the original image on the rotated graphics context
        graphics2d.drawImage(sprite, 0, 0, null);
        // Dispose of the graphics context
        graphics2d.dispose();
        // Create a new ImageIcon from the rotated BufferedImage
        sprite = new ImageIcon(rotatedImage).getImage();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(sprite, 100, 100, null);
    }
}
