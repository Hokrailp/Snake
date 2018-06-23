/**
 *
 * Класс, отвечающий за работу всего приложения(всей игры)
 *
 */
public class Game {

    public static int speed = 100;
    private int score = 0;

    public static void main(String args[]) throws InterruptedException {
        new Painter("Snake");
    }

}
