import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Класс, отвечающий за работу всего приложения(всей игры)
 */
public class Game {

    public static int speed = 100;
    public static int size = 25;
    private int score = 0;
    public static Painter window;
    public static JLayeredPane screen;
    public static int startX;
    public static int startY;
    private World world;
    private int lastKeyPressed;
    public static Map<Integer, AbstractElement.Direction> charDir = new HashMap<>();

    public void lose() {

    }

    private void initMap () {
        charDir.put (83, AbstractElement.Direction.DOWN);
        charDir.put (65, AbstractElement.Direction.LEFT);
        charDir.put (87, AbstractElement.Direction.UP);
        charDir.put (68, AbstractElement.Direction.RIGHT);
        charDir.put (81, AbstractElement.Direction.IDLE);
        charDir.put (38, AbstractElement.Direction.UP);
        charDir.put (40, AbstractElement.Direction.DOWN);
        charDir.put (37, AbstractElement.Direction.LEFT);
        charDir.put (39, AbstractElement.Direction.RIGHT);
    }

    private void update() throws InterruptedException {
        while (true) {
            world.move(lastKeyPressed);
            lastKeyPressed = 0;
            window.paint(world);
            sleep(Game.speed);
        }
    }

    private void run () throws InterruptedException {
        window = new Painter("Snake");
        startX = window.getWidth() / 2;
        startY = window.getHeight() / 2;
        screen = window.getLayeredPane();
        world = new World(startX, startY);
        window.paint(world);
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                lastKeyPressed = e.getKeyCode();
            }
        });
        initMap();
        update();
    }

    public static void main(String args[]) throws InterruptedException {
        new Game().run();
    }

}
