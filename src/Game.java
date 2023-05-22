import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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
    }
    
    public void Update() {
        checkEatenFood();
        checkCollideWall();
        checkCollideSelf();

        if (keyboard.wasKeyPressed("left") && snakeDirection != Snake.Direction.RIGHT) snakeDirection = Snake.Direction.LEFT;
        else if (keyboard.wasKeyPressed("right") && snakeDirection != Snake.Direction.LEFT) snakeDirection = Snake.Direction.RIGHT;
        else if (keyboard.wasKeyPressed("up") && snakeDirection != Snake.Direction.DOWN) snakeDirection = Snake.Direction.UP;
        else if (keyboard.wasKeyPressed("down") && snakeDirection != Snake.Direction.UP) snakeDirection = Snake.Direction.DOWN;
    }
    
    public void Draw() {
        window.draw();
        for (Snake bodyPart:snake) window.add(bodyPart.get());
        window.add(food.get());
        window.add(background.get(), window.getLayerDepth() + 1);
    }

    public void checkCollideSelf() {
        for (Snake bodyPart:snake) {
            if (bodyPart.getPosition().equals(snake.get(0).getPosition()) && bodyPart != snake.get(0))
                endGame();
        }
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

    public void moveSnake() {
        moveHead(snakeDirection);

        for (int i = 1; i < snake.size(); i++) {
            snake.get(i).setPosition(
                (int) snake.get(i-1).getLastPosition().getX(),
                (int) snake.get(i-1).getLastPosition().getY()
            );
            snake.get(i).setLastDirection(snake.get(i).getDirection());
            snake.get(i).setDirection(snake.get(i-1).getLastDirection());

            if (i != snake.size()-1) {
                if (snake.get(i-1).getDirection() != snake.get(i).getDirection()) {
                    if (snake.get(i-1).getDirection() == Snake.Direction.LEFT 
                            && snake.get(i).getDirection() == Snake.Direction.UP) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.RIGHT);
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.LEFT 
                            && snake.get(i).getDirection() == Snake.Direction.DOWN) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.DOWN);
                    } 
                    else if (snake.get(i-1).getDirection() == Snake.Direction.RIGHT 
                            && snake.get(i).getDirection() == Snake.Direction.UP) {
                        snake.get(i).setTexture("SnakeCorner.png");
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.RIGHT 
                            && snake.get(i).getDirection() == Snake.Direction.DOWN) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.LEFT);
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.UP 
                            && snake.get(i).getDirection() == Snake.Direction.LEFT) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.LEFT);
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.UP 
                            && snake.get(i).getDirection() == Snake.Direction.RIGHT) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.DOWN);
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.DOWN 
                            && snake.get(i).getDirection() == Snake.Direction.LEFT) {
                        snake.get(i).setTexture("SnakeCorner.png");
                    }
                    else if (snake.get(i-1).getDirection() == Snake.Direction.DOWN 
                            && snake.get(i).getDirection() == Snake.Direction.RIGHT) {
                        snake.get(i).setTexture("SnakeCorner.png");
                        snake.get(i).setRotation(Sprite.Rotate.RIGHT);
                    }
                }
                else {
                    snake.get(i).setTexture("SnakeLine.png");
                    if (snake.get(i).getDirection() == Snake.Direction.DOWN) snake.get(i).setRotation(Sprite.Rotate.DOWN);
                    else if (snake.get(i).getDirection() == Snake.Direction.LEFT) snake.get(i).setRotation(Sprite.Rotate.LEFT);
                    else if (snake.get(i).getDirection() == Snake.Direction.RIGHT) snake.get(i).setRotation(Sprite.Rotate.RIGHT);
                }
            }

            if (snake.size() > 1) {
                snake.get(snake.size()-1).setTexture("SnakeHead.png");
        
                if (snake.get(snake.size()-2).getDirection() == Snake.Direction.UP) snake.get(snake.size()-1).setRotation(Sprite.Rotate.DOWN);
                else if (snake.get(snake.size()-2).getDirection() == Snake.Direction.DOWN) snake.get(snake.size()-1).setRotation(Sprite.Rotate.UP);
                else if (snake.get(snake.size()-2).getDirection() == Snake.Direction.LEFT) snake.get(snake.size()-1).setRotation(Sprite.Rotate.RIGHT);
                else if (snake.get(snake.size()-2).getDirection() == Snake.Direction.RIGHT) snake.get(snake.size()-1).setRotation(Sprite.Rotate.LEFT);
            }
        }
        if (snake.size() == 1) snake.get(0).setTexture("SnakeAlone.png");
        else snake.get(0).setTexture("SnakeHead.png");
        if (snake.get(0).getDirection() == Snake.Direction.UP) snake.get(0).setRotation(Sprite.Rotate.UP);
        else if (snake.get(0).getDirection() == Snake.Direction.DOWN) snake.get(0).setRotation(Sprite.Rotate.DOWN);
        else if (snake.get(0).getDirection() == Snake.Direction.LEFT) snake.get(0).setRotation(Sprite.Rotate.LEFT);
        else if (snake.get(0).getDirection() == Snake.Direction.RIGHT) snake.get(0).setRotation(Sprite.Rotate.RIGHT);
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
        config.setRunWhenClosed(() -> {
            System.out.println("test");
        });
        config.excludeInsets(true);
        config.configureAllSettings(window);
    }
}
