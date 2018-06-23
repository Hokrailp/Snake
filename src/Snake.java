import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * Gоловa и "подзмейкa"
 * пока что сделана
 */
public class Snake {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, IDLE
    }

    private int xVelocity = 0;
    private int yVelocity = 0;
    private int x, y;

    private Direction direction;
    private Snake next = null;

    public Figure square = new Figure(Color.red);

    public Snake() {
        this(0, 0);
    }

    public Snake(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        Game.screen.add(square);
        this.direction = direction;
    }

    public Snake(int x, int y) {
        this(x, y, Direction.IDLE);
    }

    private void makeMove() {
        x += xVelocity;
        y += yVelocity;
    }

    public void move(){
        boolean changedDirection = false;
        makeMove();
        moveNext(direction);
        if (next != null)
            next.move();
    }

    public void moveNext(Direction direction) {
        this.direction = direction;
        if (next == null) return;
        switch (direction) {
            case UP:
                next.moveUp();
                break;
            case DOWN:
                next.moveDown();
                break;
            case LEFT:
                next.moveLeft();
                break;
            case RIGHT:
                next.moveRight();
                break;
            default:
                break;
        }
    }

    public void moveLeft() {
        xVelocity = -1;
        yVelocity = 0;
        moveNext(Direction.LEFT);
    }

    public void moveRight() {
        xVelocity = 1;
        yVelocity = 0;
        moveNext(Direction.RIGHT);
    }

    public void moveUp() {
        xVelocity = 0;
        yVelocity = -1;
        moveNext(Direction.UP);
    }

    public void moveDown() {
        xVelocity = 0;
        yVelocity = 1;
        moveNext(Direction.DOWN);
    }

    public void grow() {
        int nX, nY;
        nX = x - xVelocity;
        nY = y - yVelocity;
        next = new Snake(nX, nY, direction);
        moveNext(direction);
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

    public Snake getNext() {
        return next;
    }

    public Direction getDirection() {
        return direction;
    }
}
