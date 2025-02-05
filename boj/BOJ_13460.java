import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int n, m;
    private static char[][] map;
    private static int[] rLocation;
    private static int[] bLocation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        input(br);
        initializeBallPosition();
        solve();

    }

    private static void input(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }
    }

    private static void initializeBallPosition() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    rLocation = new int[]{i, j};
                }
                if (map[i][j] == 'B') {
                    bLocation = new int[]{i, j};
                }
            }
        }
    }

    private static void solve() {
        boolean[][][][] visited = new boolean[n][m][n][m];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, bLocation[0], bLocation[1], rLocation[0], rLocation[1]));
        visited[bLocation[0]][bLocation[1]][rLocation[0]][rLocation[1]] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.depth > 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int[] rMoveResult = move(point.rx, point.ry, dx[i], dy[i]);
                int[] bMoveResult = move(point.bx, point.by, dx[i], dy[i]);

                if (map[bMoveResult[0]][bMoveResult[1]] == 'O') {
                    continue;
                }
                if (map[rMoveResult[0]][rMoveResult[1]] == 'O') {
                    System.out.println(point.depth);
                    return;
                }

                checkBallPosition(rMoveResult, bMoveResult, i);
                continueBFS(visited, bMoveResult, rMoveResult, queue, point);
            }
        }
        System.out.println(-1);
    }

    private static void continueBFS(boolean[][][][] visited, int[] bMoveResult, int[] rMoveResult, Queue<Point> queue, Point point) {
        if (!visited[bMoveResult[0]][bMoveResult[1]][rMoveResult[0]][rMoveResult[1]]) {
            queue.add(new Point(point.depth + 1, bMoveResult[0], bMoveResult[1], rMoveResult[0], rMoveResult[1]));
            visited[bMoveResult[0]][bMoveResult[1]][rMoveResult[0]][rMoveResult[1]] = true;
        }
    }

    private static void checkBallPosition(int[] rMoveResult, int[] bMoveResult, int i) {
        if (rMoveResult[0] == bMoveResult[0] && rMoveResult[1] == bMoveResult[1]) {
            if (rMoveResult[2] > bMoveResult[2]) {
                rMoveResult[0] -= dx[i];
                rMoveResult[1] -= dy[i];
            } else {
                bMoveResult[0] -= dx[i];
                bMoveResult[1] -= dy[i];
            }
        }
    }

    private static int[] move(int x, int y, int dx, int dy) {
        int cnt = 0;
        while (map[x + dx][y + dy] != '#') {
            x += dx;
            y += dy;
            cnt++;
            if (map[x][y] == 'O') {
                break;
            }
        }
        return new int[]{x, y, cnt};
    }

    static class Point {
        int rx;
        int ry;
        int bx;
        int by;
        int depth;

        public Point(int depth, int bx, int by, int rx, int ry) {
            this.bx = bx;
            this.by = by;
            this.depth = depth;
            this.rx = rx;
            this.ry = ry;
        }
    }
}
