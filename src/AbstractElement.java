import java.awt.*;

/**
 * Gоловa и "подзмейкa"
 * пока что сделана
 */
public abstract class AbstractElement {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, IDLE
    }

    int xVelocity;
    int yVelocity;
    int x, y;

    Direction direction;

    private Figure square = new Figure(Color.red);

    public AbstractElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public AbstractElement(AbstractElement other) {
        this.yVelocity = other.getyVelocity();
        this.xVelocity = other.getxVelocity();
        this.y = other.getY();
        this.x = other.getX();
        this.direction = other.getDirection();
    }

    public Figure getSquare() {
        return square;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private BodyPart create (AbstractElement other) {
        return new BodyPart (other);
    }

    public AbstractElement grow() {
        int nX, nY;
        nX = x - xVelocity;
        nY = y - yVelocity;
        AbstractElement temp = create (this);
        temp.setX(nX);
        temp.setY(nY);
        return temp;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public Direction getDirection() {
        return direction;
    }
}
