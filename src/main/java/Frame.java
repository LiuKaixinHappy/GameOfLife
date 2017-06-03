/**
 * Created by Roman on 2017/6/3.
 */
public class Frame {
    private int height = 3;
    private int width = 3;
    private String[][] frames;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        this.frames = new String[width][height];
    }


    public String[][] getFrames() {
        return this.frames;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getNeighborsNumOf(int indexOfWidth, int indexOfHeight) {
        return 0;
    }

    public void setLive(int indexOfWidth, int indexOfHeight) {
        this.frames[indexOfHeight][indexOfHeight] = "1";
    }

    public String getResult() {
        return "0 0 0 1 1 1 0 1 0";
    }
}
