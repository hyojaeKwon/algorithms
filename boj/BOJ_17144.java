import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17144 {
    public static int row, column;
    public static int[][][] map;

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    private static int airRowUp;
    private static int airRowDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        map = new int[row][column][2];

        ArrayList<Integer> air = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if(map[i][j][0]==-1) {
                    air.add(i);
                }
            }
        }
        airRowUp = air.get(0);
        airRowDown = air.get(1);

        for (int t = 0; t < time; t++) {
            clearMap();
            for (int i = 0; i < row; i++) {
                for(int j = 0; j < column; j++) {
                    if (!isAirCleaner(j, i)) {
                        spread(i, j);
                    }
                }
            }
            merge();
            circularClockwise();
            circularCounterClockwise();
        }

        System.out.println(calculate());

    }

    public static int calculate() {
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                counter += map[i][j][0];
            }
        }
        return counter + 2;
    }

    public static void merge() {
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if (!isAirCleaner(j, i)) {
                    map[i][j][0] = map[i][j][0] + map[i][j][1];
                }
            }
        }
    }

    public static void spread(int row, int column) {

        int nowAir = map[row][column][0];
        int spreadAmount = nowAir / 5;

        int times = 0;
        for (int i = 0; i < 4; i++) {
            int nx = column + dx[i];
            int ny = row + dy[i];
            if(isWall(ny, nx) ) {
                if (!isAirCleaner(nx, ny)) {
                    map[ny][nx][1] = map[ny][nx][1] + spreadAmount;
                    times++;
                }
            }
        }
        map[row][column][0] = nowAir - times * spreadAmount;

    }

    public static boolean isWall(int nrow, int ncol) {
        return nrow >= 0 && ncol >= 0 && nrow < row && ncol < column;
    }

    public static boolean isAirCleaner(int nCol, int nRow) {
        if (nCol == 0) {
            return nRow == airRowDown || nRow == airRowUp;
        }
        return false;
    }

    // 공기가 시계방향으로 순환 = airRowDown
    public static void circularClockwise() {
        // 위로
        for (int i = 0; i < row - airRowDown - 2; i++) {
            int tmp = map[airRowDown + 2 + i][0][0];
            map[airRowDown + 1 + i][0][0] = tmp;
        }
        // 왼쪽으로
        if(row - 1 != airRowDown){
            for (int i = 0; i < column - 1; i++) {
                int tmp = map[row-1][i + 1][0];
                map[row-1][i][0] = tmp;
            }
        }
        // 아래쪽으로
        for (int i = 0; i < row - airRowDown - 1; i++) {
            int tmp = map[row - 2 - i][column - 1][0];
            map[row - i - 1][column - 1][0] = tmp;
        }
        // 오른쪽으로
        for (int i = 0; i < column - 2; i++) {
            int tmp = map[airRowDown][column - 2 - i][0];
            map[airRowDown][column - i - 1][0] = tmp;
        }
        map[airRowDown][1][0] = 0;
    }
    public static void circularCounterClockwise() {

        // 아래쪽으로
        for (int i = 0; i < airRowUp - 1; i++) {
            int tmp = map[airRowUp - 2 - i][0][0];
            map[airRowUp - 1 - i][0][0] = tmp;
        }
        if (row -2 != airRowUp) {
            // 오른쪽으로
            for (int i = 0; i < column - 1; i++) {
                int tmp = map[0][i + 1][0];
                map[0][i][0] = tmp;
            }
        }
        // 위로
        for (int i = 0; airRowUp > i; i++) {
            int tmp = map[i+1][column - 1][0];
            map[i][column - 1][0] = tmp;
        }
        // 왼쪽으로
        for (int i = 0; i < column - 2; i++) {
            int tmp = map[airRowUp][column - 2 - i][0];
            map[airRowUp][column - i - 1][0] = tmp;
        }
        map[airRowUp][1][0] = 0;
    }

    public static void clearMap() {
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                map[i][j][1] = 0;
            }
        }
    }

}
