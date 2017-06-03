/**
 * Created by Roman on 2017/6/3.
 */
public class MyFrame {
    private int height;
    private int width;
    private String[][] frames;
    private String[][] answerFrames;
    private static final int BORDER_NUM = 8;
    public static final String LIVE = "1";
    public static final String DEAD = "0";
    private final int[][] border = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

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
        }
        return liveNumSum;
    }

    public void dfs(int posx,int posy){
        for(int i=0;i<8;i++)
        {
            int positionX = posx + border[i][0];
            int positionY = posy + border[i][1];
            if (isInBorder(positionX, positionY))
            {
                changeStatus(positionX,positionY);
                dfs(positionX,positionY);
            }
        }
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
        width = lines.length;
        height = lines[0].length();
        this.frames = new String[width][height];
        this.answerFrames = new String[width][height];
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
        frames = answerFrames;
        answerFrames = frames;
    }

    public void changeStatus(int x,int y) {
        if (getLiveNeighborsNumOf(x, y) == 3) {
            setLive(x, y);
        } else if (getLiveNeighborsNumOf(x, y) != 2) {
            setDead(x, y);
        }
    }

    public String[][] getFrames() {
        return frames;
    }

    public String[][] getAnswerFrame() {
        return answerFrames;
    }
}
