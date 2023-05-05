package Game;
import javax.swing.JFrame;

import Utils.Keyboard;
import Utils.Sprite;
import Utils.Window;
import Utils.WindowConfiguration;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private Sprite sprite;

    public Game() {
        window = new Window();
        configureWindow(window);
        keyboard = new Keyboard();
        sprite = new Sprite("test.png", 100, 100);
    }

    public void Initialize() {
        
    }

    public void Update() {
        sprite.setRotation(sprite.getRotation() + 1);
        sprite.setPosition((int) sprite.getPosition().getX() + 3, (int) sprite.getPosition().getY());
        if (keyboard.isKeyDown("a")) System.out.println("A key is down!"); else System.out.println("A key isn't down!");
    }

    public void Draw() {
        window.draw();
        window.add(sprite.get());
        window.add(keyboard);
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Example Window");
        config.setSize(1000, 600);
        config.setLocation(100, 100);
        config.setVisible(true);
        config.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        config.setRunWhenClosed(() -> {
            System.out.println("This is a test!");
        });
        config.configureAllSettings(window);
    }
}
