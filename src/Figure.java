import javax.swing.*;
import java.awt.*;

public class Figure extends JComponent
{
    private Color color;

    public void setColor (Color color) {
        this.color = color;
    }

    Figure(Color color) {
        this.color = color;
        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(0, 0, Game.scale, Game.scale);
    }
}
