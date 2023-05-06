package Utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Constants.Constants;

public class Sprite {
    private BufferedImage buffImage;
    private JPanel panel;
    private int x, y, width, height;
    private String directory;
    private double rotation;

    public enum ScaleMode {
        CORNER,
        CENTER
    }

    public Sprite(String imgFileName, int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        rotation = 0.0;

        String dir = "";
        char[] dirCharArr = Constants.content.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            dir += letter=='\\'?"/":letter;
        directory = dir + "/src/Content/" + imgFileName;
        
        loadBufferedImage();
        setWidth(width);
        setHeight(height);
        refreshPanel();
    }

    public void scale(double precentScale) {
        Image tempImage = buffImage.getScaledInstance(
            (int) ((double) (width*precentScale)), 
            (int) ((double) (height*precentScale)), 
            BufferedImage.SCALE_FAST);
        BufferedImage scaledImage = new BufferedImage(
            (int) ((double) (width*precentScale)), 
            (int) ((double) (height*precentScale)), 
            buffImage.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();
        buffImage = scaledImage;

        int widthDifferent = Math.abs(this.width - (int) ((double) (this.width*precentScale)));
        boolean gettingSmaller = this.width > (int) ((double) (this.width*precentScale)); 
        if (gettingSmaller) x+=widthDifferent/2; else x-=widthDifferent/2; 

        int heightDifferent = Math.abs(this.height - (int) ((double) (this.height*precentScale)));
        gettingSmaller = this.height > (int) ((double) (this.height*precentScale)); 
        if (gettingSmaller) y+=heightDifferent/2; else y-=heightDifferent/2; 

        width = (int) ((double) (width*precentScale));
        height = (int) ((double) (height*precentScale));
    }

    public void setWidth(int width) { setWidth(width, ScaleMode.CORNER); }
    public void setWidth(int width, ScaleMode scaleMode) {
        Image tempImage = buffImage.getScaledInstance(width, height, BufferedImage.SCALE_FAST);
        BufferedImage scaledImage = new BufferedImage(width, height, buffImage.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();
        buffImage = scaledImage;

        if (scaleMode == ScaleMode.CENTER) {
            int widthDifferent = Math.abs(this.width - width);
            boolean gettingSmaller = this.width > width; 
            if (gettingSmaller) x+=widthDifferent/2; else x-=widthDifferent/2; 
        }
        this.width = width;
    }

    public void setHeight(int height) { setHeight(height, ScaleMode.CORNER); }
    public void setHeight(int height, ScaleMode scaleMode) {
        Image tempImage = buffImage.getScaledInstance(width, height, BufferedImage.SCALE_FAST);
        BufferedImage scaledImage = new BufferedImage(width, height, buffImage.getType());
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.drawImage(tempImage, 0, 0, null);
        g2d.dispose();
        buffImage = scaledImage;

        if (scaleMode == ScaleMode.CENTER) {
            int heightDifferent = Math.abs(this.height - height);
            boolean gettingSmaller = this.height > height; 
            if (gettingSmaller) y+=heightDifferent/2; else y-=heightDifferent/2; 
        }
        this.height = height;
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
                Graphics2D g2d = (Graphics2D) g;
                g2d.rotate(Math.toRadians(rotation), x+buffImage.getWidth()/2, y+buffImage.getHeight()/2);
                g2d.drawImage(buffImage, x, y, null);
            }
        };
    }

    public JPanel get() { return panel; }
}
