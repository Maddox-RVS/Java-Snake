import javax.swing.JLabel;

import Utils.*;
import Utils.Grid.Translate;

public class Food {
    private Sprite foodTexture;
    private final Grid grid;

    public Food(int x, int y) {
        grid = new Grid(50, 50);
        x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        foodTexture = new Sprite("TestApple.png", 50, 50, x, y);
    }

    public void setPosition(int x, int y) { 
        x = (int) grid.get(x, y, Translate.FROM_GRID).getX();
        y = (int) grid.get(x, y, Translate.FROM_GRID).getY();
        foodTexture.setPosition(x, y); 
    }
    public Vector2D getPosition() { return foodTexture.getPosition(); }
    public JLabel get() { return foodTexture.get(); }
}
