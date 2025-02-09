package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 석유시추_시간초과 {

    static class Solution {

        private static int column, row;

        private static final int[] dx = {1, -1, 0, 0};
        private static final int[] dy = {0, 0, 1, -1};

        public static int solution(int[][] land) {
            int max = 0;
            column = land[0].length;
            row = land.length;

            for (int i = 0; i < column; i++) {
                max = Math.max(max, found(i, land));
            }
            return max;
        }

        private static int found(int point, int[][] land) {
            int gas = 0;

            boolean[][] visit = new boolean[row][column];
            for (int i = 0; i < row; i++) {
                if (!visit[i][point] && land[i][point] == 1) {
                    // bfs
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, point});
                    visit[i][point] = true;

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
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
                }
            }
            return gas;
        }
    }
}
