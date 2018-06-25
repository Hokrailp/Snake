import javax.swing.*;
import java.util.List;

public class Painter extends JFrame {

    public void paint (World world) {
        paintFood(world.getFood());
        paintSnake(world.getSnake());
    }

    private void paintFood (Food food) {

    }

    private void paintSnake(List<AbstractElement> snake) {
        for (AbstractElement e : snake) {
            e.getSquare().setBounds(Game.startX + (e.getX() - Game.startX) * Game.size, Game.startY + (e.getY() - Game.startY) * Game.size, Game.size, Game.size);
        }
    }

    public Painter (String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

}
