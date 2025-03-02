package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    class Solution {

        int[][] map = new int[101][101];
        boolean[][] visit = new boolean[101][101];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

            for (int[] tmp : rectangle) {
                for (int i = tmp[0] * 2; i <= tmp[2] * 2; i++) {
                    for (int j = tmp[1] * 2; j <= tmp[3] * 2; j++) {
                        if (map[i][j] == 1) {
                            continue;
                        }
                        map[i][j] = 1;
                        if (i == tmp[0] * 2 || i == tmp[2] * 2 || j == tmp[1] * 2 || j == tmp[3] * 2) {
                            map[i][j] = 2;
                        }
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            int answer = 10000;
            visit[characterX * 2][characterY * 2] = true;
            queue.add(new int[]{characterX * 2, characterY * 2, 0});

            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();

                if (tmp[0] == itemX * 2 && tmp[1] == itemY * 2) {
                    answer = Math.min(answer, tmp[2]);
                    visit[tmp[0]][tmp[1]] = false;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = tmp[0] + dx[i];
                    int ny = tmp[1] + dy[i];

                    if (0 < nx && nx < 101 && 0 < ny && ny < 101) {
                        if (!visit[nx][ny] && map[nx][ny] == 2) {
                            queue.add(new int[]{nx, ny, tmp[2] + 1});
                            visit[nx][ny] = true;
                        }
                    }
                }
            }

            return answer / 2;
        }
    }
}
