package Utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Constants.Constants;

public class Sprite {
    private BufferedImage buffImage;
    private BufferedImage universalBuffImage;
    private JLabel image;
    private int x, y, width, height;
    private String directory;
    private Rotate rotation;

    public enum ScaleMode {
        CORNER,
        CENTER
    }

    public enum Rotate {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Sprite(String imgFileName, int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        String dir = "";
        char[] dirCharArr = Constants.DIRECTORY.toCharArray();
        for (char letter:dirCharArr)
            dir += letter=='\\'?"/":letter;
        directory = dir + "/src/Content/";
        
        loadBufferedImage(imgFileName);
        universalBuffImage = new BufferedImage(buffImage.getWidth(), buffImage.getHeight(), buffImage.getType());
        Graphics2D graphics = universalBuffImage.createGraphics();
        graphics.drawImage(buffImage, null, 0, 0);
        setWidth(width);
        setHeight(height);
        this.image = new JLabel();
    }

    public void scale(double precentScale) {
        Image tempImage = buffImage.getScaledInstance(
            (int) ((double) (width*precentScale)), 
            (int) ((double) (height*precentScale)), 
            BufferedImage.SCALE_SMOOTH);
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
        Image tempImage = buffImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
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
        Image tempImage = buffImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
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

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D getPosition() { return new Vector2D(x, y); }

    public int getWidth() { return buffImage.getWidth(); }
    public int getHeight() { return  buffImage.getHeight(); }

    public Rotate getRotation() { return rotation; }
    public void setRotation(Rotate rotation) {
        BufferedImage rotatedImage = new BufferedImage(
            universalBuffImage.getWidth(), 
            universalBuffImage.getHeight(), 
            universalBuffImage.getType());
        Graphics2D graphics = rotatedImage.createGraphics();
        if (rotation == Rotate.UP) graphics.rotate(
            Math.toRadians(0), 
            universalBuffImage.getWidth()/2, 
            universalBuffImage.getHeight()/2);
        else if (rotation == Rotate.DOWN) graphics.rotate(
            Math.toRadians(180), 
            universalBuffImage.getWidth()/2, 
            universalBuffImage.getHeight()/2);
        else if (rotation == Rotate.LEFT) graphics.rotate(
            Math.toRadians(270), 
            universalBuffImage.getWidth()/2, 
            universalBuffImage.getHeight()/2);
        else if (rotation == Rotate.RIGHT) graphics.rotate(
            Math.toRadians(90), 
            universalBuffImage.getWidth()/2, 
            universalBuffImage.getHeight()/2); 
        graphics.drawImage(universalBuffImage, null, 0, 0);
        graphics.dispose();
        buffImage = rotatedImage;
        this.rotation = rotation;
    }

    public void loadBufferedImage(String imgFileName) { 
        try {
            Image image = ImageIO.read(new File(directory + imgFileName));
            buffImage = new BufferedImage(
                image.getWidth(null), 
                image.getHeight(null), 
                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffImage.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            g2d.dispose();
        } catch (Exception e) {
            Logger.write("[ERROR] Failed to load -> " + directory + imgFileName, e.getMessage(), e);
        }
    }

    public void setTexture(String imgFileName) {
        loadBufferedImage(imgFileName);
        setWidth(width);
        setHeight(height);
        Graphics2D graphics = universalBuffImage.createGraphics();
            graphics.drawImage(buffImage, null, 0, 0);
            graphics.dispose();
    }

    public JLabel get() { 
        image.setIcon(new ImageIcon(buffImage));
        image.setLayout(null);
        image.setLocation(x, y);
        image.setSize(width, height);

        return image;
    }
}
