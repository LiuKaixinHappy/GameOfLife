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

    public DrawCellFrame(int frameWidth, int frameHeight) {
        StringBuilder initFrames = new StringBuilder();
        try {
            Files.lines(Paths.get("init_frames.txt"), StandardCharsets.UTF_8).forEach(initFrames::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = frameWidth;
        height = frameHeight;
        myFrame = new MyFrame(width, height);
        myFrame.setFrame(initFrames.toString());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        frames = myFrame.getAnswerFrame();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (frames[i][j].equals(MyFrame.DEAD)) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.RED);
                }

                g.fillRect(i * 100, j * 100, 100, 100);
            }
        }
        try {
            Thread.sleep(100);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myFrame.changeStatus();
    }
}
