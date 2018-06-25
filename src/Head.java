public class Head extends AbstractElement {

    public Head(AbstractElement other) {
        super(other);
    }

    public Head(int x, int y) {
        super(x, y);
    }

    public void move () {
        x += xVelocity;
        y += yVelocity;
    }

    public void moveLeft() {
        xVelocity = -1;
        yVelocity = 0;
        direction = Direction.LEFT;
    }

    public void moveRight() {
        xVelocity = 1;
        yVelocity = 0;
        direction = Direction.RIGHT;
    }

    public void moveUp() {
        xVelocity = 0;
        yVelocity = -1;
        direction = Direction.UP;
    }

    public void moveDown() {
        xVelocity = 0;
        yVelocity = 1;
        direction = Direction.DOWN;
    }
}
