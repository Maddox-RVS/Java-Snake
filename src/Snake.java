import javax.swing.JLabel;
import Utils.*;
import Utils.Grid.Translate;

public class Snake {
    private BodyType bodyType;
    private final Grid grid;
    private Sprite bodyTexture;
    private Vector2D lastPosition;
    private Snake.Direction direction;

    public Snake(int x, int y, BodyType bodyType) {
        this.grid = new Grid(50, 50);
        this.bodyType = bodyType;
        x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        bodyTexture = new Sprite("SnakePlaceholder.png", 50, 50, x, y);
        
        if (bodyType == BodyType.HEAD) bodyTexture.setTexture("SnakeHead.png");
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

    public void Update() {
        
    }
    
    public void setPosition(int x, int y) { 
        lastPosition = new Vector2D(bodyTexture.getPosition().getX(), bodyTexture.getPosition().getY());
        bodyTexture.setPosition(x, y);
    }

    public void rotate() {
        if (direction == Snake.Direction.LEFT) bodyTexture.setRotation(Sprite.Rotate.LEFT);
        else if (direction == Snake.Direction.RIGHT) bodyTexture.setRotation(Sprite.Rotate.RIGHT);
        else if (direction == Snake.Direction.UP) bodyTexture.setRotation(Sprite.Rotate.UP);
        else if (direction == Snake.Direction.DOWN) bodyTexture.setRotation(Sprite.Rotate.DOWN);
    }
    
    public void setDirection(Snake.Direction direction) { this.direction = direction; }
    public Snake.Direction getDirection() { return direction; }
    public void setBodyType(BodyType bodyType) { this.bodyType = bodyType; }
    public Vector2D getPosition() { return bodyTexture.getPosition(); }
    public Vector2D getLastPosition() { return lastPosition; }
    public JLabel get() { return bodyTexture.get(); }
}
