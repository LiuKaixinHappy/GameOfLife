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
    private final int SIZE = 800;
    private final int ALIGNMENT = 100;
    private MyFrame myFrame;
    private int width;
    private int height;
    private int sleepTime;

    public DrawCellFrame(String fileName, int sleepTime) {
        setTitle("State");
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
        String[][] frames = myFrame.getAnswerFrame();
        int dx = SIZE / width;
        int dy = SIZE / height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (frames[i][j].equals(MyFrame.DEAD)) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLUE);
                }

                g.fillRect(ALIGNMENT + j * dx, ALIGNMENT + i * dy, ALIGNMENT, ALIGNMENT);
                g.setColor(Color.black);
                g.drawRect(ALIGNMENT + j * dx, ALIGNMENT + i * dy, ALIGNMENT, ALIGNMENT);
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
