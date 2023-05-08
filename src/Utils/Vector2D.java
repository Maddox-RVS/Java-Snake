package Utils;

public class Vector2D {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector2D obj) {
        if (x == obj.getX() && y == obj.getY()) return true;
        return false;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public String toString() {
        return "{" + x + ", " + y + "}";
    }
}
