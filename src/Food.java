import java.awt.*;

/**
 * Каkaшkа
 */
public class Food {

    public enum Type {
        FOOD, SPEEDUP, SLOWDOWN, RESET
    }

    private int x, y;
    private int score;

    private Type type;

    private Figure square = new Figure(Color.green);

    Food() {
        this(0,0,Type.FOOD);
    }
    Food(int x, int y, Type t) {
        this.x = x;
        this.y = y;
        this.type = t;
    }
    Food(int x, int y) {
        this(x,y,Type.FOOD);
    }

    public Figure getSquare() {
        return square;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }


}
