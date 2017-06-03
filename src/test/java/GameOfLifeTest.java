import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Roman on 2017/6/3.
 */
public class GameOfLifeTest {
    @Test
    public void should_live_if_has_3_neighbors() {

        Frame frame = new Frame(3, 3);
        for (int i = 0; i < frame.getWidth(); i++) {
            for (int j = 0; j < frame.getHeight(); j++) {
                if (frame.getNeighborsNumOf(i, j) >= 3) {
                    frame.setLive(i, j);
                }
            }
        }

        assertEquals("0 0 0 1 1 1 0 1 0", frame.getResult());
    }
}
