import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс, облуживающий игровой мир
 */
public class World {
    private Snake head;
    private int length;
    private boolean eaten;
    private Painter painter;
    private Food food;

    public Snake getHead () {
        return head;
    }

    public Food getFood() {
        return food;
    }

    public void move (char key) {
        Snake.Direction dir = head.getDirection();
        switch (key) {
            case 's':
                if (dir != Snake.Direction.UP)
                    head.moveDown();
                break;
            case 'w':
                if (dir != Snake.Direction.DOWN)
                    head.moveUp();
                break;
            case 'd':
                if (dir != Snake.Direction.LEFT)
                    head.moveRight();
                break;
            case 'a':
                if (dir != Snake.Direction.RIGHT)
                    head.moveLeft();
                break;
            case 'q':
                head.grow();
                break;
        }
    }

    World(int x, int y) {
        head = new Snake(x, y);
    }

    public void instantiateFood() {

    }
}