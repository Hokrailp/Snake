import javax.swing.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private char lastKeyPressed;

    public void lose() {

    }

    public void update() throws InterruptedException {
        while (true) {
            world.move(lastKeyPressed);
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
                lastKeyPressed = e.getKeyChar();
            }
        });
        update();
    }

    public static void main(String args[]) throws InterruptedException {
        new Game().run();
    }

}
