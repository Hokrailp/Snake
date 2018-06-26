import javax.swing.*;
import java.util.List;

public class Painter extends JFrame {

    public void paintScore (int score, JTextField scoreText) {
        scoreText.setBounds(getWidth() - 250, 0, 250, 35);
        scoreText.setText("Score: " + score);
    }

    public void paint(World world) {
        paintFood(world.getFood());
        paintSnake(world.getSnake());
    }

    private void paintFood(Food food) {
        food.getSquare().setBounds(food.getX() * Game.scale, food.getY() * Game.scale, Game.scale, Game.scale);
    }

    private void paintSnake(List<AbstractElement> snake) {
        for (AbstractElement e : snake) {
            e.getSquare().setBounds(e.getX() * Game.scale, e.getY() * Game.scale, Game.scale, Game.scale);
        }
    }

    public Painter(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }

}
