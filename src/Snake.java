import javax.swing.JLabel;
import Utils.*;
import Utils.Grid.Translate;
import Utils.Sprite.Rotate;

public class Snake {
    private BodyType bodyType;
    private final Grid grid;
    private Sprite bodyTexture;
    private Vector2D lastPosition;
    private Snake.Direction direction;
    private Snake.Direction lastDirection;

    public Snake(int x, int y, BodyType bodyType) {
        this.grid = new Grid(50, 50);
        this.bodyType = bodyType;
        x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        bodyTexture = new Sprite("SnakeHead.png", 50, 50, x, y);
    }

    public enum BodyType {
        HEAD,
        LINE_BODY,
        CORNER_BODY,
        TAIL
    }

    public enum Direction {
        NONE,
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    
    public void setPosition(int x, int y) { 
        lastPosition = new Vector2D(bodyTexture.getPosition().getX(), bodyTexture.getPosition().getY());
        bodyTexture.setPosition(x, y);
    }

    public void setTexture(String texture) { bodyTexture.setTexture(texture); }
    public void setDirection(Snake.Direction direction) { this.direction = direction; }
    public Direction getDirection() { return direction; }
    public void setLastDirection(Snake.Direction lastDirection) { this.lastDirection = lastDirection; }
    public Direction getLastDirection() { return lastDirection; }
    public void setBodyType(BodyType bodyType) { this.bodyType = bodyType; }
    public BodyType getBodyType() { return bodyType; }
    public Vector2D getPosition() { return bodyTexture.getPosition(); }
    public Vector2D getLastPosition() { return lastPosition; }
    public void setRotation(Rotate rotation) { bodyTexture.setRotation(rotation); }
    public JLabel get() { return bodyTexture.get(); }
}
