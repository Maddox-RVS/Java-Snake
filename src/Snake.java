import javax.swing.JLabel;
import javax.swing.JPanel;

import Utils.*;
import Utils.Grid.Translate;

public class Snake {
    private BodyType bodyType;
    private Sprite bodyTexture;
    private final Grid grid;

    public Snake(int x, int y, BodyType bodyType) {
        this.grid = new Grid(50, 50);
        this.bodyType = bodyType;
        x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        bodyTexture = new Sprite("Square.png", 50, 50, x, y);
    }

    public enum BodyType {
        HEAD,
        LINE_BODY,
        CORNER_BODY,
        TAIL
    }

    public void Update() {
        // System.out.println(x + " | " + y);
    }

    public void setPosition(int x, int y) { 
        bodyTexture.setPosition(x, y);
    }

    public Vector2D getPosition() { 
        return bodyTexture.getPosition(); 
    }

    public JLabel get() {
        return bodyTexture.get();
    }
}
