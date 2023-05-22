import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.SNIHostName;
import javax.swing.JFrame;

import Snake.Direction;
import Utils.*;
import Utils.Grid.Translate;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private Grid grid;
    private final Sprite background;
    private Snake.Direction snakeDirection;
    private final Timer updateSnakeMovement;
    private int snakeSpeed;
    private ArrayList<Snake> snake = new ArrayList<Snake>();
    private Food food;
    private int score;

    public Game() {
        window = new Window();
        keyboard = new Keyboard();
        grid = new Grid(50, 50);
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);
        window.add(keyboard);
        
        snake.add(new Snake(7, 7, Snake.BodyType.HEAD));
        snake.get(0).setPosition((int) snake.get(0).getPosition().getX(), (int) snake.get(0).getPosition().getY());
        snakeDirection = Snake.Direction.NONE;

        snakeSpeed = 70;
        updateSnakeMovement = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                moveSnake();
            }
        };
        updateSnakeMovement.schedule(task, snakeSpeed, snakeSpeed*2);


        food = new Food(0, 0);
        placeFood();
        score = 0;
    }
    
    public void Update() {
        if (keyboard.wasKeyPressed("left") && 
            !keyboard.isKeyDown("right") &&
            !keyboard.isKeyDown("up") &&
            !keyboard.isKeyDown("down") && 
            snakeDirection != Snake.Direction.RIGHT) 
                snakeDirection = Snake.Direction.LEFT;
        else if (keyboard.wasKeyPressed("right") && 
            !keyboard.isKeyDown("left") &&
            !keyboard.isKeyDown("up") &&
            !keyboard.isKeyDown("down") &&
            snakeDirection != Snake.Direction.LEFT) 
                snakeDirection = Snake.Direction.RIGHT;
        else if (keyboard.wasKeyPressed("up") && 
            !keyboard.isKeyDown("right") &&
            !keyboard.isKeyDown("left") &&
            !keyboard.isKeyDown("down") && 
            snakeDirection != Snake.Direction.DOWN) 
                snakeDirection = Snake.Direction.UP;
        else if (keyboard.wasKeyPressed("down") && 
            !keyboard.isKeyDown("right") &&
            !keyboard.isKeyDown("up") &&
            !keyboard.isKeyDown("left") && 
            snakeDirection != Snake.Direction.UP) 
                snakeDirection = Snake.Direction.DOWN;
    }
    
    public void Draw() {
        window.draw();
        for (int i = 0; i < snake.size(); i++) window.add(snake.get(i).get());
        window.add(food.get());
        window.add(background.get(), window.getLayerDepth() + 1);
    }

    public void moveSnake() {
        moveHead(snakeDirection);
        if (snake.size() > 10) {
            Logger.write(Integer.toString(snake.size()));
            window.get().getLayeredPane().remove(snake.get(1).get());
            snake.remove(1);
        }
        if (snakeDirection != Snake.Direction.NONE) increaseSnakeLength();
    }

    public void checkCollideWall() {
        if (snake.get(0).getPosition().getX() < 0 || 
            snake.get(0).getPosition().getX() > window.getWidth() - snake.get(0).get().getWidth())
            endGame();
        if (snake.get(0).getPosition().getY() < 0 || 
            snake.get(0).getPosition().getY() > window.getHeight() - snake.get(0).get().getHeight())
            endGame();
    }

    public boolean checkEatenFood() {
        if (snake.get(0).getPosition().equals(food.getPosition())) {
            placeFood();
            score++;
            return true;
        }
        return false;
    }

    public void placeFood() {
        Vector2D foodPosition = generateFoodPosition();
        food.setPosition((int) foodPosition.getX(), (int) foodPosition.getY());
    }
    
    public void moveHead(Snake.Direction direction) {
        snake.get(0).setLastDirection(snake.get(0).getDirection());
        if (direction == Snake.Direction.LEFT)
            snake.get(0).setPosition(
                (int) snake.get(0).getPosition().getX() - 50, 
                (int) snake.get(0).getPosition().getY()); 
        else if (direction == Snake.Direction.RIGHT)
            snake.get(0).setPosition(
                (int) snake.get(0).getPosition().getX() + 50, 
                (int) snake.get(0).getPosition().getY());
        else if (direction == Snake.Direction.UP)
            snake.get(0).setPosition(
                (int) snake.get(0).getPosition().getX(), 
                (int) snake.get(0).getPosition().getY() - 50);
        else if (direction == Snake.Direction.DOWN)
            snake.get(0).setPosition(
                (int) snake.get(0).getPosition().getX(), 
                (int) snake.get(0).getPosition().getY() + 50);
        snake.get(0).setDirection(direction);
    }

    public void increaseSnakeLength() {
        int x = (int) snake.get(0).getLastPosition().getX();
        int y = (int) snake.get(0).getLastPosition().getY();
        snake.add(new Snake(
            (int) grid.get(x, y, Grid.Translate.TO_GRID).getX(),
            (int) grid.get(x, y, Grid.Translate.TO_GRID).getY(),
            Snake.BodyType.LINE_BODY));
    }
    
    public Vector2D generateFoodPosition() {
        int x = MathHelper.random(0, 14); 
        int y = MathHelper.random(0, 14);
        for (Snake bodyPart:snake) 
            if (bodyPart.getPosition().equals(new Vector2D(
                grid.get(x, y, Translate.FROM_GRID).getX(), 
                grid.get(x, y, Translate.FROM_GRID).getY()))) 
                    return generateFoodPosition();
        return new Vector2D(x, y);
    }

    public void endGame() {
        System.exit(0);
    }

    public void configureWindow(Window window) {
        var config = new WindowConfiguration();
        config.setTitle("Snake");
        config.setSize(750, 750);
        config.excludeInsets(true);
        config.setResizable(false);
        config.setLocation(400, 10);
        config.setVisible(true);
        config.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        config.excludeInsets(true);
        config.configureAllSettings(window);
    }
}
