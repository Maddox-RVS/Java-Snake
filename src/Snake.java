import javax.swing.JPanel;

import Utils.*;
import Utils.Grid.Translate;

public class Snake {
    private BodyType bodyType;
    private Sprite bodyTexture;
    private final Grid grid;
    private int x;
    private int y;

    public Snake(int x, int y, BodyType bodyType) {
        this.grid = new Grid(50, 50);
        this.bodyType = bodyType;
        this.x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        this.y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        bodyTexture = new Sprite("Square.png", 50, 50, x, y);
    }

    public enum BodyType {
        HEAD,
        LINE_BODY,
        CORNER_BODY,
        TAIL
    }

    public void Update() {

    }

    public JPanel get() {
        return bodyTexture.get();
    }
}
