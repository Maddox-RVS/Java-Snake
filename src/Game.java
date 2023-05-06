
import javax.swing.JFrame;

import Utils.*;

public class Game {
    private final Window window;
    private final Sprite background;
    private Snake[] snake = new Snake[1]; 

    public Game() {
        window = new Window();
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);

        snake[0] = new Snake(7, 7, Snake.BodyType.HEAD);
    }

    public void Update() {
        for (Snake bodyPart:snake) bodyPart.Update();
    }

    public void Draw() {
        window.draw();
        window.add(background.get());
        for (Snake bodyPart:snake) window.add(bodyPart.get());
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
