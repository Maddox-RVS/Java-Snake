
import javax.swing.JFrame;

import Utils.Keyboard;
import Utils.Sprite;
import Utils.Window;
import Utils.WindowConfiguration;

public class Game {
    private final Window window;
    private final Sprite background;

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
        config.setLocation(400, 30);
        config.setVisible(true);
        config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        config.excludeInsets(true);
        config.configureAllSettings(window);
    }
}
