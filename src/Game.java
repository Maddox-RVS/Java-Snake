import javax.swing.JFrame;
import Utils.*;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private final Sprite background;
    private Snake[] snake = new Snake[1]; 
    private boolean right, left, up, down;

    public Game() {
        window = new Window();
        keyboard = new Keyboard();
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);
        window.add(keyboard);
        
        snake[0] = new Snake(7, 7, Snake.BodyType.HEAD);
    }
    
    public void Update() {
        for (Snake bodyPart:snake) bodyPart.Update();

        if (keyboard.wasKeyPressed("left") && !right) {
            left = true;
            right = false;
            up = false;
            down = false;
        }
        if (keyboard.wasKeyPressed("right") && !left) {
            left = false;
            right = true;
            up = false;
            down = false;
        }
        if (keyboard.wasKeyPressed("up") && !down) {
            left = false;
            right = false;
            up = true;
            down = false;
        }
        if (keyboard.wasKeyPressed("down") && !up) {
            left = false;
            right = false;
            up = false;
            down = true;
        }

        if (left) snake[0].setPosition((int) snake[0].getPosition().getX() - 50, (int) snake[0].getPosition().getY()); 
        else if (right) snake[0].setPosition((int) snake[0].getPosition().getX() + 50, (int) snake[0].getPosition().getY()); 
        else if (up) snake[0].setPosition((int) snake[0].getPosition().getX(), (int) snake[0].getPosition().getY() - 50); 
        else if (down) snake[0].setPosition((int) snake[0].getPosition().getX(), (int) snake[0].getPosition().getY() + 50); 
    }
    
    public void Draw() {
        window.draw();
        for (Snake bodyPart:snake) window.add(bodyPart.get());
        window.add(background.get());
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Snake");
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
