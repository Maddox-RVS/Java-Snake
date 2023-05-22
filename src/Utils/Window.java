package Utils;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.Component;
import java.awt.event.*;

public class Window {
    private JFrame window;
    private JLayeredPane graphicsLayer;
    private Runnable runWhenClosed = ()->{};
    private int layerDepth;
    
    public Window() {
        layerDepth = 0;
        window = new JFrame();
        window.setLayout(null);
        window.setTitle("Window");
        window.setSize(300, 200);
        window.setLocation(100, 100);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                runWhenClosed.run();
                System.exit(0);
            }
        });
    }

    public enum Inset {
        INCLUDE,
        EXCLUDE
    }

    public void draw() {
        window.repaint();
    }

    public Vector2D getSize() {
        return (new Vector2D(window.getSize().getWidth(), window.getSize().getHeight()));
    }

    public int getWidth() { return getWidth(Inset.INCLUDE); }
    public int getWidth(Inset inset) { 
        if (inset == Inset.INCLUDE)
            return window.getWidth();
        return window.getWidth() + window.getInsets().right + 7; 
    }

    public int getHeight() { return getHeight(Inset.INCLUDE); }
    public int getHeight(Inset inset) {
        if (inset == Inset.INCLUDE) 
            return window.getHeight();
        return window.getHeight() + window.getInsets().top + 7; 
    }

    public void add(Component comp) {
        if (window.getLayeredPane().getIndexOf(comp) == -1) {
            window.getLayeredPane().add(comp, layerDepth);
            layerDepth++;
        }
    }

    public void add(Component comp, int layerDepth) {
        if (window.getLayeredPane().getIndexOf(comp) == -1) {
            window.getLayeredPane().add(comp, layerDepth);
        }
    }

    public void add(Keyboard keyboard) {
        window.addKeyListener(keyboard);
    }

    public int getLayerDepth() { return layerDepth; }
    public JFrame get() { return window; }
    public JLayeredPane getLayeredPane() { return graphicsLayer; }
    public void setRunWhenClosed(Runnable runWhenClosed) { this.runWhenClosed = runWhenClosed; }
}
