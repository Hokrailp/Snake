import javax.swing.*;

public class Painter extends JFrame {
    @SuppressWarnings("All")
    public Painter (String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Game.size, Game.size);
        setVisible(true);
    }

    public void paint (World world) {
        paintFood(world.getFood());
        paintSnake(world.getHead());
    }

    private void paintFood (Food food) {

    }

    private void paintSnake(Snake snake) {
        snake.square.setBounds(snake.getX() * Game.scale, snake.getY() * Game.scale, Game.scale, Game.scale);
        Snake next = snake.getNext();
        if (next != null) {
            paintSnake(next);
        }
    }
}
