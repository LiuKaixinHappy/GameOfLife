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
        Frame frame = new Frame(3, 3);
        frame.setFrame(initFrames.toString());
        frame.changeStatus();
        assertEquals("000010010", frame.getResult());
    }

    @Test
    public void should_get_1_if_one_has_1_live_neighbors() {
        Frame frame = new Frame(3, 3);
        frame.setFrame("000|101|010");
        assertEquals(1, frame.getLiveNeighborsNumOf(0, 0), 0);
    }

    @Test
    public void should_get_3_if_one_has_3_live_neighbors() {
        Frame frame = new Frame(3, 3);
        frame.setFrame("000|101|010");
        assertEquals(3, frame.getLiveNeighborsNumOf(1, 1), 0);
    }

}
