/**
 * Created by Roman on 2017/6/3.
 */
public class Frame {
    private int height = 3;
    private int width = 3;
    private final String[][] frames;
    private String[][] answerFrames;
    private static final int BORDER_NUM = 8;
    private static final String LIVE = "1";
    private static final String DEAD = "0";
    private final int[][] border = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        this.frames = new String[width][height];
        this.answerFrames = new String[width][height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLiveNeighborsNumOf(int indexOfWidth, int indexOfHeight) {
        int liveNumSum = 0;
        for (int i = 0; i < BORDER_NUM; i++) {
            int positionX = indexOfWidth + border[i][0];
            int positionY = indexOfHeight + border[i][1];
            if (isInBorder(positionX, positionY) && LIVE.equals(frames[positionX][positionY])) {
                liveNumSum++;
            }
            if (liveNumSum >= 3) {
                return liveNumSum;
            }
        }
        return liveNumSum;
    }

    private boolean isInBorder(int positionX, int positionY) {
        return (positionX >= 0 && positionX < width) && (positionY >= 0 && positionY < height);
    }

    public void setLive(int indexOfWidth, int indexOfHeight) {
        this.answerFrames[indexOfWidth][indexOfHeight] = LIVE;
    }

    public String getResult() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                answer.append(this.answerFrames[i][j]);
            }
        }
        return answer.toString();
    }

    public void setFrame(String frame) {
        String[] lines = frame.split("\\|");
        for (int row = 0; row < lines.length; row++) {
            String line = lines[row];
            String[] cols = line.split("");
            for (int col = 0; col < cols.length; col++) {
                this.frames[row][col] = cols[col];
                this.answerFrames[row][col] = cols[col];
            }
        }
    }

    public void setDead(int indexOfWidth, int indexOfHeight) {
        this.answerFrames[indexOfWidth][indexOfHeight] = DEAD;
    }

    public void changeStatus() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (getLiveNeighborsNumOf(i, j) == 3) {
                    setLive(i, j);
                } else if (getLiveNeighborsNumOf(i, j) != 2) {
                    setDead(i, j);
                }
            }
        }
    }
}
