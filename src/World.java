

/**
 * Класс, облуживающий игровой мир
 */
public class World {

    static int WIDTH = 800/Game.scale;
    static int HEIGHT = 800/Game.scale;

    private Snake head;
    private Snake tail;
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
        switch (key) {
            case 'q':
                tail = tail.grow();
                head.move('0');
                break;
            default:
                head.move(key);
                break;
        }
    }

    World(int x, int y) {
        head = new Snake(x, y);
        tail = head;
    }

    public void instantiateFood() {

    }
}