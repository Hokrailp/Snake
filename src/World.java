import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс, облуживающий игровой мир
 * 0 - пустая клетка
 * 1 - змея
 * 2 - еда
 */
public class World {

    static int WIDTH = Game.window.getWidth() / Game.scale;
    static int HEIGHT = Game.window.getHeight() / Game.scale;

    private int[][] worldGrid;
    private Random random = new Random();
    private int length;
    private boolean eaten;
    private Food food;

    FileWriter writer = new FileWriter("out.txt");

    private List<AbstractElement> Snake = new ArrayList<>();

    public List<AbstractElement> getSnake() {
        return Snake;
    }

    public Food getFood() {
        return food;
    }

    private boolean isCollising (int key) {
        switch (key) {
            case 0:
                return worldGrid[Snake.get(0).getY()][Snake.get(0).getX()] == 2;
            case 1:
                return worldGrid[Snake.get(0).getY()][Snake.get(0).getX()] == 1;
        }
        return false;
    }

    private Pair<Integer, Integer> pickLocation() {
        Head head = (Head) Snake.get(0);
        int foodX = Math.abs(random.nextInt()) % (WIDTH - 2);
        int foodY = Math.abs(random.nextInt()) % (HEIGHT - 2);
        while (foodX == head.getX() && foodY == head.getY()) {
            foodX = Math.abs(random.nextInt()) % (WIDTH - 2);
            foodY = Math.abs(random.nextInt()) % (HEIGHT - 2);
        }
        return new Pair<>(foodX, foodY);
    }

    private void pickLocationAndPlace() {
        Pair<Integer, Integer> foodAxis = pickLocation();
        food.setX(foodAxis.getKey());
        food.setY(foodAxis.getValue());
        Food.Type typeAndColor = Food.Type.values()[Math.abs(random.nextInt()) % Food.Type.values().length];
        food.setType(typeAndColor);
        food.getSquare().setColor(Game.typeColor.get(typeAndColor));
        worldGrid[food.getY()][food.getX()] = 2;
    }

    private void foodAction(Food.Type type) {
        switch (type) {
            case FOOD:
                break;
            case RESET:
                int size = Snake.size();
                for (int i = size - 1; i > 0; i--) {
                    worldGrid[Snake.get(i).getY()][Snake.get(i).getX()] = 0;
                    Game.window.remove(Snake.get(i).getSquare());
                    Snake.remove(i);
                    Game.window.repaint();
                }
                break;
            case SPEEDUP:
                Game.speed = 75;
                break;
            case SLOWDOWN:
                Game.speed = 200;
                break;
        }
    }

    private void eatFood() {
        if (isCollising(0)) {
            Game.increaseScore(Snake.size());
            grow();
            foodAction(food.getType());
            pickLocationAndPlace();
        }
    }

    private void eatOurselves () {
        if (isCollising(1)) {
            Game.lose();
        }
    }

    private void copy(AbstractElement lhs, AbstractElement rhs) {
        lhs.setX(rhs.getX());
        lhs.setY(rhs.getY());
        lhs.setxVelocity(rhs.getxVelocity());
        lhs.setyVelocity(rhs.getyVelocity());
    }

    private void instantiateHead (int x, int y) {
        Head init = new Head(x, y);
        Game.window.add(init.getSquare());
        Snake.add(init);
        worldGrid[init.getY()][init.getX()] = 1;
    }

    private void instantiateFood() {
        Pair<Integer, Integer> foodAxis = pickLocation();
        food = new Food(foodAxis.getKey(), foodAxis.getValue());
        Game.window.add(food.getSquare());
        worldGrid[food.getY()][food.getX()] = 2;
    }

    private void init(int x, int y) {
        worldGrid = new int[WIDTH][HEIGHT];
        instantiateHead(x, y);
        instantiateFood();
    }

    private void grow() {
        BodyPart tail = (BodyPart) Snake.get(Snake.size() - 1).grow();
        Snake.add(tail);
        Game.window.add(Snake.get(Snake.size() - 1).getSquare());
        worldGrid[tail.getY()][tail.getX()] = 1;
    }

    private void move() {
        worldGrid[Snake.get(Snake.size() - 1).getY()][Snake.get(Snake.size() - 1).getX()] = 0;
        if (Snake.size() > 1) {
            for (int i = Snake.size() - 1; i > 0; i--) {
                copy(Snake.get(i), Snake.get(i - 1));
            }
        }
        ((Head) Snake.get(0)).move();
        eatFood();
        eatOurselves();
        worldGrid[Snake.get(0).getY()][Snake.get(0).getX()] = 1;
    }

    public void move(int key) throws IOException {
        AbstractElement head = Snake.get(0);
        AbstractElement.Direction dir = head.getDirection();
        AbstractElement.Direction Key = Game.intDir.get(key);
        if (Key != null)
            switch (Key) {
                case DOWN:
                    if (dir != AbstractElement.Direction.UP)
                        ((Head) head).moveDown();
                    break;
                case UP:
                    if (dir != AbstractElement.Direction.DOWN)
                        ((Head) head).moveUp();
                    break;
                case RIGHT:
                    if (dir != AbstractElement.Direction.LEFT)
                        ((Head) head).moveRight();
                    break;
                case LEFT:
                    if (dir != AbstractElement.Direction.RIGHT)
                        ((Head) head).moveLeft();
                    break;
                case IDLE:
                    /*for (int i = 0; i < WIDTH - 1; i++) {
                        for (int j = 0; j < HEIGHT - 2; j++) {
                            writer.write(worldGrid[i][j] + " ");
                        }
                        writer.write("\n");
                    }
                    writer.write("\n---------------------------\n");
                    writer.close();*/
                    break;
            }
        move();
    }

    World(int x, int y) throws IOException {
        init(x, y);
    }

}