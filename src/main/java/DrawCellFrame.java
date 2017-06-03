import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Roman on 2017/6/3.
 */
public class DrawCellFrame extends JFrame {
    private MyFrame myFrame;
    private int width;
    private int height;
    private String[][] frames;
    private int sleepTime;

    public DrawCellFrame(String fileName, int sleepTime) {
        StringBuilder initFrames = new StringBuilder();
        try {
            Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).forEach(initFrames::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        myFrame = new MyFrame();
        myFrame.setFrame(initFrames.toString());
        width = myFrame.getWidth();
        height = myFrame.getHeight();
        this.sleepTime = sleepTime;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        frames = myFrame.getAnswerFrame();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (frames[i][j].equals(MyFrame.DEAD)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.RED);
                }

                g.fillRect(100 + j * 800 / width, 100 + i * 800 / height, 100, 100);
            }
        }
        try {
            Thread.sleep(sleepTime);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myFrame.changeStatus();
    }
}
