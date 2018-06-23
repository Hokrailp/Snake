import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class Painter extends JFrame {

    private JLayeredPane screen = getLayeredPane();
    private Snake snake = new Snake();
    private int startX = 400;
    private int startY = 400;
    private int curX = startX;
    private int curY = startY;
    private int size = 25;

    private void run () throws InterruptedException {
        Figure head = new Figure(Color.red);
        head.setBounds(startX, startY, size, size);
        screen.add(head);
        while (true) {
            int xv = snake.getxVelocity() * size;
            int yv = snake.getyVelocity() * size;
            curX += xv;
            curY += yv;
            head.setBounds(curX, curY, size, size);
            sleep(Game.speed);
        }
    }

    public Painter (String title) throws InterruptedException {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Snake.Direction dir = snake.getDirection();
                switch (e.getKeyChar()) {
                    case 's':
                        if (dir != Snake.Direction.UP)
                            snake.moveDown();
                        break;
                    case 'w':
                        if (dir != Snake.Direction.DOWN)
                            snake.moveUp();
                        break;
                    case 'd':
                        if (dir != Snake.Direction.LEFT)
                            snake.moveRight();
                        break;
                    case 'a':
                        if (dir != Snake.Direction.RIGHT)
                            snake.moveLeft();
                        break;
                }
            }
        });
        setSize(800, 800);
        setVisible(true);
        run();
    }

}
