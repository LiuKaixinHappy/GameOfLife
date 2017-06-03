import javax.swing.*;

/**
 * Created by Roman on 2017/6/3.
 */
public class Client {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameOfLife.setVisible(true);
    }
}
