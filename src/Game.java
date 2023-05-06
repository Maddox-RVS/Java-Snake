
import javax.swing.JFrame;

import Utils.Keyboard;
import Utils.Sprite;
import Utils.Window;
import Utils.WindowConfiguration;
import Utils.MathHelper;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private Sprite sprite;
    private int rotation = 0;

    public Game() {
        window = new Window();
        configureWindow(window);
        keyboard = new Keyboard();
        sprite = new Sprite("test.png", 100, 100, 100, 100);
    }

    public void Update() {
        if (keyboard.isKeyDown("left"))
            sprite.setPosition((int) sprite.getPosition().getX() - 6, (int) sprite.getPosition().getY());
        else if (keyboard.isKeyDown("right"))
            sprite.setPosition((int) sprite.getPosition().getX() + 6, (int) sprite.getPosition().getY());
        else sprite.setHeight(100, Sprite.ScaleMode.CENTER);
        if (keyboard.isKeyDown("up"))
            sprite.setPosition((int) sprite.getPosition().getX(), (int) sprite.getPosition().getY() - 6);
        else if (keyboard.isKeyDown("down"))
            sprite.setPosition((int) sprite.getPosition().getX(), (int) sprite.getPosition().getY() + 6);
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
        config.excludeInsets(true);
        config.setResizable(true);
        config.setLocation(100, 100);
        config.setVisible(true); //TODO Currently doesn't work because of window refresh, need to fix!
        config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        config.configureAllSettings(window);
    }
}
