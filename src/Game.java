import javax.swing.JFrame;
import Utils.*;

public class Game {
    private final Window window;
<<<<<<< HEAD
    private final Sprite background;
    private Snake[] snake = new Snake[1]; 
=======
    private final Keyboard keyboard;
    private Sprite sprite;
    private Sprite sprite2;
>>>>>>> game-framework

    public Game() {
        window = new Window();
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);
<<<<<<< HEAD

        snake[0] = new Snake(7, 7, Snake.BodyType.HEAD);
=======
        keyboard = new Keyboard();
        sprite = new Sprite("test.png", 100, 100, 100, 100);
        sprite2 = new Sprite("test.png", 100, 100, 400, 100);
>>>>>>> game-framework
    }

    public void Update() {
        for (Snake bodyPart:snake) bodyPart.Update();
    }

    public void Draw() {
        window.draw();
<<<<<<< HEAD
        window.add(background.get());
        for (Snake bodyPart:snake) window.add(bodyPart.get());
=======
        
        window.add(sprite.get());
        window.add(sprite2.get());

        window.add(keyboard);
>>>>>>> game-framework
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
