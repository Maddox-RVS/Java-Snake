
import javax.swing.JFrame;

import Utils.*;

public class Game {
    private final Window window;
<<<<<<< HEAD
    private final Sprite background;
=======
    private final Keyboard keyboard;
    private Sprite sprite;
>>>>>>> game-framework

    public Game() {
        window = new Window();
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);
    }

    public void Update() {

    }

    public void Draw() {
        window.draw();
        window.add(background.get());
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Example Window");
        config.setSize(750, 750);
        config.excludeInsets(true);
        config.setResizable(false);
        config.setLocation(400, 10);
        config.setVisible(true); //TODO Currently doesn't work because of window refresh, need to fix!
        config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        config.excludeInsets(true);
        config.configureAllSettings(window);
    }
}
