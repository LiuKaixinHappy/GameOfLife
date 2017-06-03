
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLife extends JFrame implements ActionListener {

    private JTextField sleepTimeText = new JTextField();
    private JTextField fileNameText = new JTextField();

    public GameOfLife() {
        setSize(900, 150);
        setTitle("Game Of Life");
        setBackground(Color.YELLOW);
        JButton startButton = new JButton("开始");
        startButton.addActionListener(this);
        startButton.setContentAreaFilled(false);

        JPanel allPanel = new JPanel(new GridLayout(1, 5));
        allPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));

        JLabel fileNameLabel = new JLabel("文件名", JLabel.CENTER);
        allPanel.add(fileNameLabel);
        allPanel.add(fileNameText);

        JLabel sleepTimeLabel = new JLabel("间隔", JLabel.CENTER);
        allPanel.add(sleepTimeLabel);
        allPanel.add(sleepTimeText);
        allPanel.add(startButton);

        add(allPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "开始":
                if (fileNameText.getText().isEmpty() || sleepTimeText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(GameOfLife.this,
                            "不能为空!", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    showStatus();
                }
                break;
        }
    }

    private void showStatus() {
        int sleepTime = 0;
        try {
            sleepTime = Integer.valueOf(sleepTimeText.getText());
            String fileName = fileNameText.getText() + ".txt";
            DrawCellFrame newFrame = new DrawCellFrame(fileName, sleepTime);
            newFrame.setSize(1000, 1000);
            newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            newFrame.setVisible(true);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(GameOfLife.this,
                    "输入非法!", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }


}