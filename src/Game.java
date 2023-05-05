import javax.swing.JFrame;

public class Game {
    private final Window window;
    private Sprite sprite;

    public Game() {
        window = new Window();
        configureWindow(window);
        sprite = new Sprite("test.png", 100, 100, 100, 100);
    }

    public void Initialize() {
        
    }

    public void Update() {
        sprite.rotate(sprite.getRotation() + 1);
    }

    public void Draw() {
        window.draw();
        window.add(sprite.get());
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Example Window");
        config.setSize(600, 400);
        config.setLocation(100, 100);
        config.setVisible(true);
        config.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        config.setRunWhenClosed(() -> {
            System.out.println("This is a test!");
        });
        config.configureAllSettings(window);
    }
}
