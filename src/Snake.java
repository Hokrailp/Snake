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

    private Direction direction = Direction.IDLE;
    private Snake next = null;

    public Snake() {
        x=0;
        y=0;
    }
    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void move(Direction direction) {
        if (next==null) return;
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
    public void moveLeft () {
        xVelocity = -1;
        yVelocity = 0;
        direction = Direction.LEFT;
        x+=xVelocity;
        y+=yVelocity;
        move(direction);
    }
    public void moveRight () {
        xVelocity = 1;
        yVelocity = 0;
        direction = Direction.RIGHT;
        x+=xVelocity;
        y+=yVelocity;
        move(direction);
    }
    public void moveUp () {
        xVelocity = 0;
        yVelocity = -1;
        direction = Direction.UP;
        x+=xVelocity;
        y+=yVelocity;
        move(direction);
    }
    public void moveDown () {
        xVelocity = 0;
        yVelocity = 1;
        direction = Direction.DOWN;
        x+=xVelocity;
        y+=yVelocity;
        move(direction);
    }

    public Snake grow() {
        int nX,nY;
        nX = x-xVelocity;
        nY = y-yVelocity;
        next = new Snake(nX,nY);
        return next;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getxVelocity () {
        return xVelocity;
    }
    public int getyVelocity() {
        return yVelocity;
    }

    public Direction getDirection () {
        return direction;
    }
}
