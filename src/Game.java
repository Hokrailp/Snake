
import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import static java.lang.Thread.sleep;

/**
 * Класс, отвечающий за работу всего приложения(всей игры)
 */
public class Game {

    public static HashMap<Character, Snake.Direction> Key_Dir = new HashMap<>();

    public static int speed = 200;
    public static int size = 800;
    public static int scale = 25;
    private int score = 0;
    public static Painter window;
    public static JLayeredPane screen;
    public static int startX;
    public static int startY;
    private World world;
    private char lastKeyPressed;

    public void update() throws InterruptedException {
        while (true) {
            world.move(lastKeyPressed);
            lastKeyPressed = 0;
            window.paint(world);
            sleep(Game.speed);
        }
    }

    private void run () throws InterruptedException {
        window = new Painter("Snake");
        //World.HEIGHT = 800/25;
        //World.WIDTH = 800/25;
        startX = World.WIDTH/2;
        startY = World.HEIGHT/2;
        screen = window.getLayeredPane();
        world = new World(startX, startY);
        window.paint(world);
        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                lastKeyPressed = e.getKeyChar();
            }
        });
        update();
    }

    public static void main(String args[]) throws InterruptedException {
        new Game().run();
    }

}
