import javax.swing.*;

public class Painter extends JFrame {

    public void paint (World world) {
        paintFood(world.getFood());
        paintSnake(world.getHead());
    }

    private void paintFood (Food food) {

    }

    private void paintSnake(Snake snake) {
        snake.square.setBounds(Game.startX + (snake.getX() - Game.startX) * Game.size, Game.startY + (snake.getY() - Game.startY) * Game.size, Game.size, Game.size);
        Snake next = snake.getNext();
        if (next != null) {
            paintSnake(snake.getNext());
        }
    }

    public Painter (String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

}
