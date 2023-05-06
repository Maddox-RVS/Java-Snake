package Utils;

public class Grid {
    private int cellWidth;
    private int cellHeight;
    
    public Grid(int cellWidth, int cellHeight) {
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
    }

    public enum Translate {
        TO_GRID,
        FROM_GRID
    }

    public Vector2D get(int x, int y, Translate translation) {
        if (translation == Translate.TO_GRID) {
            return new Vector2D(x - (x%cellWidth), y - (y%cellHeight));
        }
        else {
            return new Vector2D(x * cellWidth, y * cellHeight);
        }
    }

    public Vector2D cellSize() {
        return new Vector2D(cellWidth, cellHeight);
    }
}
