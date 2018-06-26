import java.awt.*;

/**
 * Каkaшkа
 */
public class Food {

    public enum Type {
        FOOD, SPEEDUP, SLOWDOWN, RESET
    }

    private int x, y;

    private Type type;

    private Figure square = new Figure(Color.green);

    Food() {
        this(0, 0, Type.FOOD);
    }

    Food(int x, int y, Type t) {
        this.x = x;
        this.y = y;
        this.type = t;
    }

    Food(int x, int y) {
        this(x, y, Type.FOOD);
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

    public Type getType() {
        return type;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
