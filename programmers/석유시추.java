package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 석유시추 {

    static class Solution {

        private static final int[] dx = {1, -1, 0, 0};
        private static final int[] dy = {0, 0, 1, -1};
        private static int column, row;
        private static boolean[][] visit;
        private static int[] value;

        public static int solution(int[][] land) {
            int max = 0;
            column = land[0].length;
            row = land.length;
            value = new int[column];
            Arrays.fill(value, 0);

            visit = new boolean[row][column];

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    if (!visit[j][i] && land[j][i] == 1) {
                        found(i, j, land);
                    }
                }
            }
            return Arrays.stream(value).max().getAsInt();
        }

        private static void found(int startX, int startY, int[][] land) {
            int gas = 0;
            boolean[] gasVisit = new boolean[column];

            // bfs
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startY, startX});
            visit[startY][startX] = true;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                gasVisit[now[1]] = true;
                gas++;
                for (int j = 0; j < 4; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];
                    if (0 <= nx && nx < column && 0 <= ny && ny < row) {
                        if (!visit[ny][nx] && land[ny][nx] == 1) {
                            queue.add(new int[]{ny, nx});
                            visit[ny][nx] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < column; i++) {
                if (gasVisit[i]) {
                    value[i] += gas;
                }
            }
        }
    }
}
