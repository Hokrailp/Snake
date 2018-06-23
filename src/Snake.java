public class Snake {

    public enum Direction {
        LEFT, RIGHT, UP, DOWN, IDLE
    }

    private int xVelocity = 0;
    private int yVelocity = 0;
    private int length = 1;
    private Direction direction = Direction.IDLE;

    public void moveLeft () {
        xVelocity = -1;
        yVelocity = 0;
        direction = Direction.LEFT;
    }

    public void moveRight () {
        xVelocity = 1;
        yVelocity = 0;
        direction = Direction.RIGHT;
    }

    public void moveUp () {
        xVelocity = 0;
        yVelocity = -1;
        direction = Direction.UP;
    }

    public void moveDown () {
        xVelocity = 0;
        yVelocity = 1;
        direction = Direction.DOWN;
    }

    public int getxVelocity () {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public int getLength() {
        return length;
    }

    public Direction getDirection () {
        return direction;
    }
}
