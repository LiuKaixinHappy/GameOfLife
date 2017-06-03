import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLifeTest {
    @Test
    public void should_000010000_if_000101010() throws IOException {
        StringBuilder initFrames = new StringBuilder();
        Files.lines(Paths.get("init_frames.txt"), StandardCharsets.UTF_8).forEach(initFrames::append);
        MyFrame myFrame = new MyFrame(3, 3);
        myFrame.setFrame(initFrames.toString());
        myFrame.changeStatus();
        assertEquals("000010010", myFrame.getResult());
    }

    @Test
    public void should_get_1_if_one_has_1_live_neighbors() {
        MyFrame myFrame = new MyFrame(3, 3);
        myFrame.setFrame("000|101|010");
        assertEquals(1, myFrame.getLiveNeighborsNumOf(0, 0), 0);
    }

    @Test
    public void should_get_3_if_one_has_3_live_neighbors() {
        MyFrame myFrame = new MyFrame(3, 3);
        myFrame.setFrame("000|101|010");
        assertEquals(3, myFrame.getLiveNeighborsNumOf(1, 1), 0);
    }

}
