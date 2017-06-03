
import javax.swing.*;
import java.awt.*;

/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLife extends JFrame {

    private JPanel allPanel = new JPanel(new BorderLayout());
    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel(new GridLayout(4, 1));

    private JButton randomButton = new JButton("生成细胞");
    private JButton startButton = new JButton("开  始");
    private JButton stopButton = new JButton("结  束");

    private JTextField frameSizeText = new JTextField();

    public GameOfLife() {
        setSize(800, 500);
        leftPanel.setSize(600, 500);
        rightPanel.setSize(200, 500);
        rightPanel.add(frameSizeText);
        rightPanel.add(randomButton);
        rightPanel.add(startButton);
        rightPanel.add(stopButton);
        allPanel.add(leftPanel, BorderLayout.WEST);
        allPanel.add(rightPanel, BorderLayout.EAST);
        add(allPanel);
    }

}
