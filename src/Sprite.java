import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Sprite extends JPanel {
    private Image sprite;
    private BufferedImage buffImage;
    private JPanel panel;
    private int width, height, x, y;
    private String directory;
    private double rotation;

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
        sprite = new ImageIcon(directory).getImage();
        
        loadBufferedImage();
        refreshPanel();
    }

    public void rotate(double degrees) {
        // BufferedImage rotatedImage = new BufferedImage(sprite.getWidth(null), sprite.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Graphics2D graphics2d = buffImage.createGraphics();
        // int centerX = buffImage.getWidth(null)/2;
        // int centerY = buffImage.getHeight(null)/2;
        // graphics2d.rotate(Math.toRadians(degrees), centerX, centerY);
        // graphics2d.drawImage(sprite, 0, 0, null);
        // graphics2d.dispose();
        // sprite = new ImageIcon(buffImage).getImage();
        // buffImage = 
        // refreshPanel();

        // Graphics2D graphics2d = buffImage.createGraphics();
        // int centerX = buffImage.getWidth(null)/2;
        // int centerY = buffImage.getHeight(null)/2;
        // graphics2d.rotate(Math.toRadians(degrees), centerX, centerY);
        // graphics2d.drawImage(buffImage, null, centerX, centerY);
        // graphics2d.dispose();
        rotation = degrees;
        refreshPanel();
    }
    public double getRotation() { return rotation; }

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
                g2.rotate(Math.toRadians(rotation), buffImage.getWidth(), buffImage.getHeight());
                g2.drawImage(buffImage, x, y, null);
            }
        };
    }

    // @Override
    // public void paintComponent(Graphics graphics) {
    //     super.paintComponent(graphics);
    //     graphics.drawImage(sprite, x, y, null);
    // }
    public JPanel get() { return panel; }
}
