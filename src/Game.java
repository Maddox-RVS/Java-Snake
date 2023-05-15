import javax.swing.JFrame;

import Utils.*;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private Sprite sprite;
    private Sprite background;

    public Game() {
        window = new Window();
        configureWindow(window);
        keyboard = new Keyboard();
        sprite = new Sprite("test2.png", 100, 100, 100, 100);
        sprite.setRotation(Sprite.Rotate.DOWN);
        background = new Sprite("Background.png", 750, 750, 0, 0);
    }

    public void Update() {
        if (keyboard.isKeyDown("left")) {
            sprite.setPosition((int) sprite.getPosition().getX() - 6, (int) sprite.getPosition().getY());
            sprite.setTexture("test2.png");
            sprite.setRotation(Sprite.Rotate.LEFT);
        }
        else if (keyboard.isKeyDown("right")) {
            sprite.setPosition((int) sprite.getPosition().getX() + 6, (int) sprite.getPosition().getY());
            sprite.setTexture("test2.png");
            sprite.setRotation(Sprite.Rotate.RIGHT);
        }
        if (keyboard.isKeyDown("up")) {
            sprite.setPosition((int) sprite.getPosition().getX(), (int) sprite.getPosition().getY() - 6);
            sprite.setTexture("test3.png");
            sprite.setRotation(Sprite.Rotate.UP);
        }
        else if (keyboard.isKeyDown("down")) {
            sprite.setPosition((int) sprite.getPosition().getX(), (int) sprite.getPosition().getY() + 6);
            sprite.setTexture("test3.png");
            sprite.setRotation(Sprite.Rotate.DOWN);
        }
    }

    public void Draw() {
        window.draw();
        
        window.add(sprite.get());
        window.add(background.get());

        window.add(keyboard);
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Example Window");
        config.setSize(750, 750);
        config.excludeInsets(true);
        config.setResizable(true);
        config.setLocation(400, 20);
        config.setVisible(true);
        config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        config.configureAllSettings(window);
    }
}
