import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс, облуживающий игровой мир
 */
public class World {

    static int WIDTH = Game.window.getWidth() / Game.scale;
    static int HEIGHT = Game.window.getHeight() / Game.scale;

    private int length;
    private boolean eaten;
    private Food food;

    private List<AbstractElement> Snake = new ArrayList<>();

    public List<AbstractElement> getSnake() {
        return Snake;
    }

    public Food getFood() {
        return food;
    }

    private void copy(AbstractElement lhs, AbstractElement rhs) {
        lhs.setX(rhs.getX());
        lhs.setY(rhs.getY());
    }

    private void init(int x, int y) {
        Head init = new Head(x, y);
        Game.window.add(init.getSquare());
        Snake.add(init);
        Random r = new Random();
        food = new Food((r.nextInt() % WIDTH), (r.nextInt() % HEIGHT));
    }

    private void grow() {
        BodyPart tail = (BodyPart) Snake.get(Snake.size() - 1).grow();
        Snake.add(tail);
        Game.window.add(Snake.get(Snake.size() - 1).getSquare());
    }

    private void move() {
        if (Snake.size() > 1)
            for (int i = Snake.size() - 1; i > 0; i--) {
                copy(Snake.get(i), Snake.get(i - 1));
            }
        ((Head) Snake.get(0)).move();
    }

    public void move(int key) {
        AbstractElement head = Snake.get(0);
        AbstractElement.Direction dir = head.getDirection();
        AbstractElement.Direction Key = Game.charDir.get(key);
        if (Key != null)
            switch (Key) {
                case DOWN:
                    if (dir != AbstractElement.Direction.UP)
                        ((Head) head).moveDown();
                    break;
                case UP:
                    if (dir != AbstractElement.Direction.DOWN)
                        ((Head) head).moveUp();
                    break;
                case RIGHT:
                    if (dir != AbstractElement.Direction.LEFT)
                        ((Head) head).moveRight();
                    break;
                case LEFT:
                    if (dir != AbstractElement.Direction.RIGHT)
                        ((Head) head).moveLeft();
                    break;
                case IDLE:
                    grow();
                    break;
            }
        move();
    }

    World(int x, int y) {
        init(x, y);
    }

    public void instantiateFood() {

    }
}