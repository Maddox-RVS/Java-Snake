import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

import Utils.*;
import Utils.Grid.Translate;

public class Game {
    private final Window window;
    private final Keyboard keyboard;
    private Grid grid;
    private final Sprite background;
    private final Timer updateSnakeMovement;
    private int snakeSpeed;
    private ArrayList<Snake> snake = new ArrayList<Snake>();
    private ArrayList<Snake.Direction> directions = new ArrayList<Snake.Direction>();
    private Snake.Direction snakeDirection;
    private Food food;

    public Game() {
        window = new Window();
        keyboard = new Keyboard();
        grid = new Grid(50, 50);
        background = new Sprite("Background.png", 750, 750, 0, 0);
        configureWindow(window);
        window.add(keyboard);
        
        snakeSpeed = 70;
        updateSnakeMovement = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                moveSnake();
            }
        };
        updateSnakeMovement.schedule(task, snakeSpeed, snakeSpeed*2);

        snake.add(new Snake(7, 7, Snake.BodyType.HEAD));
        snake.get(0).setPosition((int) snake.get(0).getPosition().getX(), (int) snake.get(0).getPosition().getY());
        snakeDirection = Snake.Direction.NONE;

        food = new Food(0, 0);
        placeFood();
    }
    
    public void Update() {
        checkEatenFood();
        checkCollideWall();

        //Sudo code:
        //[left, up, right, down, left]
        //dir = left -> [up, right, down, left]
        //move in direction of dir
        //loop until -> []
        //if arr is empty the dir = dir
        //move in direction of dir
        //else
        //read from arr

        if (keyboard.wasKeyPressed("left")) {
            if (directions.isEmpty()) directions.add(Snake.Direction.LEFT);
            else if (directions.get(directions.size() - 1) != Snake.Direction.RIGHT)
                directions.add(Snake.Direction.LEFT);
        } 
        if (keyboard.wasKeyPressed("right")) {
            if (directions.isEmpty()) directions.add(Snake.Direction.RIGHT);
            else if (directions.get(directions.size() - 1) != Snake.Direction.LEFT)
                directions.add(Snake.Direction.RIGHT);
        } 
        if (keyboard.wasKeyPressed("up")) {
            if (directions.isEmpty()) directions.add(Snake.Direction.UP);
            else if (directions.get(directions.size() - 1) != Snake.Direction.DOWN)
                directions.add(Snake.Direction.UP);
        } 
        if (keyboard.wasKeyPressed("down")) {
            if (directions.isEmpty()) directions.add(Snake.Direction.DOWN);
            else if (directions.get(directions.size() - 1) != Snake.Direction.UP)
                directions.add(Snake.Direction.DOWN);
        }
    }
    
    public void Draw() {
        window.draw();
        for (Snake bodyPart:snake) window.add(bodyPart.get());
        window.add(food.get());
        window.add(background.get(), window.getLayerDepth() + 1);
    }

    public void checkCollideWall() {
        if (snake.get(0).getPosition().getX() < 0 || 
            snake.get(0).getPosition().getX() > window.getWidth() - snake.get(0).get().getWidth())
            endGame();
        if (snake.get(0).getPosition().getY() < 0 || 
            snake.get(0).getPosition().getY() > window.getHeight() - snake.get(0).get().getHeight())
            endGame();
    }

    public void checkEatenFood() {
        if (snake.get(0).getPosition().equals(food.getPosition())) {
            placeFood();
            increaseSnakeLength();
        }
    }

    public void placeFood() {
        Vector2D foodPosition = generateFoodPosition();
        food.setPosition((int) foodPosition.getX(), (int) foodPosition.getY());
    }

    public void moveHead(Snake.Direction direction) {
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
    }

    public void moveSnake() {
        Logger.write(directions.toString());

        if (directions.isEmpty());
        else if (directions.size() == 2) {
            directions.remove(0);
            snakeDirection = directions.get(0);
        }
        else {
            snakeDirection = directions.get(0);
            if (directions.size() != 1) directions.remove(0);
        }
        moveHead(snakeDirection);
        for (int i = 1; i < snake.size(); i++) {
            snake.get(i).setPosition(
                (int) snake.get(i-1).getLastPosition().getX(),
                (int) snake.get(i-1).getLastPosition().getY()
            );
        }
        if (!keyboard.isKeyDown("down") &&
            !keyboard.isKeyDown("left") &&
            !keyboard.isKeyDown("up") && 
            !keyboard.isKeyDown("down")) {
                for (int i = 1; i < directions.size(); i++) {
                    directions.remove(i);
                }
            }
    }

    public void increaseSnakeLength() {
        snake.add(new Snake(
            (int) snake.get(snake.size()-1).getLastPosition().getX(), 
            (int) snake.get(snake.size()-1).getLastPosition().getY(), 
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
