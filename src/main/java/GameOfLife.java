
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

    private JPanel allPanel = new JPanel(new GridLayout(1,4));

    private JButton startButton = new JButton("开始");
    private JLabel fileNameLabel = new JLabel("文件名");
    private JLabel sleepTimeLabel = new JLabel("间隔");

    private JTextField sleepTimeText = new JTextField();
    private JTextField fileNameText = new JTextField();

    public GameOfLife() {
        setSize(800, 200);

        allPanel.setSize(600, 200);
        allPanel.setAlignmentX(100);
        allPanel.setAlignmentY(100);

        fileNameText.setSize(200, 100);
        sleepTimeText.setSize(200, 100);

        allPanel.add(fileNameLabel);
        allPanel.add(fileNameText);

        allPanel.add(sleepTimeLabel);
        allPanel.add(sleepTimeText);
        allPanel.add(startButton);

        add(allPanel);

        startButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "开始":
                int sleepTime = Integer.valueOf(sleepTimeText.getText());
                String fileName = fileNameText.getText() + ".txt";
                DrawCellFrame newFrame=new DrawCellFrame(fileName, sleepTime);
                newFrame.setSize(1000,1000);
                newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                newFrame.setVisible(true);
                break;
        }
    }


}