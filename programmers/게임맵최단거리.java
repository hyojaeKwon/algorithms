package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    class Solution {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public int solution(int[][] maps) {
            int targetY = maps.length;
            int targetX = maps[0].length;

            for (int i = 0; i < targetY; i++) {
                for (int j = 0; j < targetX; j++) {
                    if (maps[i][j] == 1) {
                        maps[i][j] = -1;
                    }
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            maps[0][0] = 1;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp[1] + dx[i];
                    int ny = tmp[0] + dy[i];
                    if (0 <= nx && nx < targetX && 0 <= ny && ny < targetY) {
                        if (maps[ny][nx] == -1) {
                            maps[ny][nx] = maps[tmp[0]][tmp[1]] + 1;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }

            return maps[targetY - 1][targetX - 1];
        }
    }
}
