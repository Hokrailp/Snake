import javax.swing.*;
import java.awt.*;

public class TestPainer extends JFrame {

    public TestPainer()
    {
        // создание окна
        super("The best Game you have EVER played");
        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // определение многослойной панели
        JLayeredPane lp = getLayeredPane();
        // создание трех фигур
        Figure figure1 = new Figure(Color.red);
        Figure figure2 = new Figure(Color.blue);
        Figure figure3 = new Figure(Color.cyan);
        // определение местоположения фигур в окне
        figure1.setBounds(100, 100, 25, 25);
        figure2.setBounds(60, 120, 160, 180);
        figure3.setBounds(100, 150, 25, 25);
        // добавление фигур в различные слои
        lp.add(figure1);
        lp.add(figure2);
        lp.add(figure3);
        int wtf = 100;
        for (long i = 0; i < 1000000000; i++) {
            if (i%10000000==9999999) {
                lp.remove(figure1);
                figure1.setBounds(wtf,wtf,25,25);
                wtf+=20;
            }
        }


        setSize(800, 800);
        setVisible(true);
    }

}
