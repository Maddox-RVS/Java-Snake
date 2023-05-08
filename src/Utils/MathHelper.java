package Utils;

public class MathHelper {
    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static int random(int min, int max) {
        int result = (int) (min + (Math.random()*(max+1-min)));
        return result;
    }
}
