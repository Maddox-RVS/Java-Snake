package Utils;
import javax.swing.JFrame;

import java.awt.Component;
import java.awt.event.*;

public class Window {
    private JFrame window;
    private Runnable runWhenClosed;

    public Window() {
        window = new JFrame();
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
    }

    public void draw() {
        window.repaint();
        window.setVisible(true); //TODO If set window visibility to false, this will instantly make it true again, fix it so that doesn't happen
    }

    public Vector2D getSize() {
        return (new Vector2D(window.getSize().getWidth(), window.getSize().height));
    }

    public double getWidth() { return window.getWidth(); }
    public double getHeight() { return window.getHeight(); }

    public Component add(Component comp) {
        return window.getContentPane().add(comp);
    }

    public JFrame get() { return window; }
    public void setRunWhenClosed(Runnable runWhenClosed) { this.runWhenClosed = runWhenClosed; }
}
