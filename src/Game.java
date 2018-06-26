import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * Класс, отвечающий за работу всего приложения(всей игры)
 */
public class Game {

    public static int speed = 125;
    public static int scale = 25;
    private static int score = 0;
    public static Painter window;
    public static JLayeredPane screen;
    public static int startX;
    public static int startY;
    private World world;
    private int lastKeyPressed;
    private JTextField scoreText;
    public static Map<Integer, AbstractElement.Direction> intDir = new HashMap<>();
    public static Map<Food.Type, Color> typeColor = new HashMap<>();
    private List<Color> colors = new ArrayList<>();

    public static void lose() {
        System.exit(1);
    }

    public static void increaseScore(int by) {
        score += by;
    }

    private void initMap () {
        colors.add(Color.green);
        colors.add(Color.blue);
        colors.add(Color.black);
        colors.add(Color.yellow);
        colors.add(Color.pink);
        colors.add(Color.cyan);
        colors.add(Color.gray);
        colors.add(Color.orange);
        colors.add(Color.darkGray);
        intDir.put (83, AbstractElement.Direction.DOWN);
        intDir.put (65, AbstractElement.Direction.LEFT);
        intDir.put (87, AbstractElement.Direction.UP);
        intDir.put (68, AbstractElement.Direction.RIGHT);
        intDir.put (69, AbstractElement.Direction.IDLE);
        intDir.put (38, AbstractElement.Direction.UP);
        intDir.put (40, AbstractElement.Direction.DOWN);
        intDir.put (37, AbstractElement.Direction.LEFT);
        intDir.put (39, AbstractElement.Direction.RIGHT);
        for (int i = 0; i < Food.Type.values().length; i++) {
            typeColor.put(Food.Type.values()[i], colors.get(i));
        }
    }

    private void update() throws InterruptedException, IOException {
        while (true) {
            world.move(lastKeyPressed);
            lastKeyPressed = 0;
            window.paint(world);
            window.paintScore(score, scoreText);
            sleep(Game.speed);
        }
    }

    private void run () throws InterruptedException, IOException {
        window = new Painter("Snake", 797, 804);
        startX = World.WIDTH / 2;
        startY = World.HEIGHT / 2;
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
        scoreText = new JTextField("Score: " + score);
        scoreText.setFont(new Font("Calibri", Font.PLAIN, 35));
        scoreText.setEditable(false);
        window.add(scoreText);
        update();
    }

    public static void main(String args[]) throws InterruptedException, IOException {
        new Game().run();
    }

}
