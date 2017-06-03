import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLifeTest {
    @Test
    public void should_live_if_has_3_neighbors() {

        Frame frame = new Frame(3, 3);
        frame.setFrame("000|101|010");
        for (int i = 0; i < frame.getWidth(); i++) {
            for (int j = 0; j < frame.getHeight(); j++) {
                if (frame.getLiveNeighborsNumOf(i, j) >= 3) {
                    frame.setLive(i, j);
                }
            }
        }

        assertEquals("000111010", frame.getResult());
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
