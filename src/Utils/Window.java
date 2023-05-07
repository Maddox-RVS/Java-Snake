package Utils;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.event.*;

public class Window {
    private JFrame window;
    private Canvas canvas = new Canvas();
    private Runnable runWhenClosed = ()->{};

    public Window() {
        window = new JFrame();
        window.setLayout(null);
        window.setTitle("Window");
        window.setSize(300, 200);
        window.setLocation(100, 100);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                runWhenClosed.run();
                System.exit(0);
            }
        });

        window.add(canvas);
    }

    public enum Inset {
        INCLUDE,
        EXCLUDE
    }

    public void draw() {
        window.repaint();
        window.setVisible(true); //TODO If set window visibility to false, this will instantly make it true again, fix it so that doesn't happen
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

    public Component add(Component comp) {
        return window.getContentPane().add(comp);
    }

    public void add(Keyboard keyboard) {
        window.addKeyListener(keyboard);
    }

    public JFrame get() { return window; }
    public void setRunWhenClosed(Runnable runWhenClosed) { this.runWhenClosed = runWhenClosed; }
}
