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
            e.getSquare().setBounds(e.getX() * Game.scale, e.getY() * Game.scale, Game.scale, Game.scale);
        }
    }

    public Painter (String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Game.window.getWidth(), Game.window.getHeight());
        setVisible(true);
    }

}
