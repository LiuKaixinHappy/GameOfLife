
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLife extends JFrame implements ActionListener {

    private JPanel allPanel = new JPanel(new BorderLayout());
//    private LeftPanel leftPanel;
    private JPanel rightPanel = new JPanel(new GridLayout(4, 1));

    private JButton randomButton = new JButton("生成细胞");
    private JButton startButton = new JButton("开始");
    private JButton stopButton = new JButton("结束");

    private JTextField frameSizeText = new JTextField();
    private JTextField sleepTimeText = new JTextField();
    private int width;
    private int height;
    private int sleepTime;

    public GameOfLife() {
        setSize(800, 500);

        rightPanel.setSize(200, 500);
        rightPanel.add(frameSizeText);
        rightPanel.add(sleepTimeText);
        frameSizeText.setText("大小");
        rightPanel.add(randomButton);
        rightPanel.add(startButton);
        rightPanel.add(stopButton);

        allPanel.add(rightPanel, BorderLayout.EAST);
//        allPanel.add(new LeftPanel(this), BorderLayout.CENTER);
        add(allPanel);

        randomButton.addActionListener(this);
        startButton.addActionListener(this);
        stopButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "生成细胞":
                break;
            case "开始":
                width = Integer.valueOf(frameSizeText.getText());
                height = Integer.valueOf(frameSizeText.getText());
                sleepTime = Integer.valueOf(sleepTimeText.getText());
                DrawCellFrame newFrame=new DrawCellFrame(width, height, sleepTime);
                newFrame.setSize(500,500);
                newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                newFrame.setVisible(true);
                break;
            case "结束":
                break;
        }
    }


    public int getFrameWidth() {
        return width;
    }

    public int getFrameHeight() {
        return height;
    }
}