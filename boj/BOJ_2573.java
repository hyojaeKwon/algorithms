import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    private static int n;
    private static int m;

    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int count = 0;
        int answer = 0;
        while (count < 2) {
            count = 0;
            answer++;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if (map[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }
            melt();
            initialVisitMap();
        }
        System.out.println(answer - 1);
    }

    private static void initialVisitMap() {
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.i + dx[k];
                int ny = p.j + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    private static void melt() {

        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
                            count++;
                        }
                    }
                    tempMap[i][j] = map[i][j] - count;
                    if(tempMap[i][j] < 0) {tempMap[i][j] = 0;}
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(tempMap[i], 0, map[i], 0, m);
        }
    }

    static class Point {
        int i;
        int j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
