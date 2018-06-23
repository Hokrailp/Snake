import java.awt.*;
import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * Gоловa и "подзмейкa"
 * пока что сделана
 */
public class Snake {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, IDLE, DEFAULT
    }

    private int xVelocity = 0;
    private int yVelocity = 0;
    private int x, y;

    private Direction direction = Direction.DEFAULT;
    private Snake next = null;

    private boolean changedDirection = false;
    private Direction lastDir;

    public Figure square = new Figure(Color.red);

    public Snake() {
        this(0, 0);
    }
    public Snake(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                break;
        }
        Game.screen.add(square);
    }
    public Snake(int x, int y) {
        this(x, y, Direction.IDLE);
    }

    private void makeMove() {
        x += xVelocity;
        y += yVelocity;
    }

    public void move(char key){
        Direction dir;
        switch (key) {
            case 'w':
                dir = Direction.UP;
                break;
            case 's':
                dir = Direction.DOWN;
                break;
            case 'a':
                dir = Direction.LEFT;
                break;
            case 'd':
                dir = Direction.RIGHT;
                break;
            default:
                dir = Direction.DEFAULT;
                break;
        }
        move(dir);
    }
    public void move(Direction d) {
        Direction dir = direction;
        switch (d) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                break;
        }
        makeMove();
        //TODO sth wrong
        if (changedDirection) {
            moveNext(direction);
            changedDirection = false;
        } else
        if (next!=null)
            next.move(lastDir);
        if (dir!=direction) {
            changedDirection = true;
            lastDir = direction;
        }
    }

    public void moveNext(Direction direction) {
        if (next == null) return;
        switch (direction) {
            case UP:
                next.move('w');
                break;
            case DOWN:
                next.move('s');
                break;
            case LEFT:
                next.move('a');
                break;
            case RIGHT:
                next.move('d');
                break;
            default:
                break;
        }
    }
    //меняют скорость и направление
    public void moveLeft() {
        if (direction==Direction.RIGHT) return;
        xVelocity = -1;
        yVelocity = 0;
        direction = Direction.LEFT;
    }
    public void moveRight() {
        if (direction==Direction.LEFT) return;
        xVelocity = 1;
        yVelocity = 0;
        direction = Direction.RIGHT;
    }
    public void moveUp() {
        if (direction==Direction.DOWN) return;
        xVelocity = 0;
        yVelocity = -1;
        direction = Direction.UP;
    }
    public void moveDown() {
        if (direction==Direction.UP) return;
        xVelocity = 0;
        yVelocity = 1;
        direction = Direction.DOWN;
    }

    public Snake grow() {
        int nX, nY;
        nX = x - xVelocity;
        nY = y - yVelocity;
        next = new Snake(nX, nY, direction);
        return next;
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
