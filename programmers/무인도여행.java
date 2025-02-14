package programmers;

import java.util.*;

public class 무인도여행 {

    class Solution {

        private final int[] dx = {1, -1, 0, 0};
        private final int[] dy = {0, 0, 1, -1};
        private int n, m;
        private boolean[][] visit;

        public int[] solution(String[] maps) {
            n = maps.length;
            m = maps[0].length();

            int[][] map = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (maps[i].charAt(j) == 'X') {
                        map[i][j] = 0;
                        continue;
                    }
                    map[i][j] = Integer.parseInt(maps[i].substring(j, j + 1));
                }
            }

            visit = new boolean[n][m];
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && map[i][j] != 0) {
                        ans.add(bfs(map, i, j));
                    }
                }
            }
            ans.sort(Comparator.naturalOrder());
            if (ans.isEmpty()) ans.add(-1);
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        private int bfs(int[][] map, int sn, int sm) {
            Queue<int[]> queue = new LinkedList<>();
            int returnValue = 0;
            queue.add(new int[]{sn, sm});
            visit[sn][sm] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                returnValue += map[cur[0]][cur[1]];

                for (int i = 0; i < 4; i++) {
                    int nn = cur[0] + dx[i];
                    int nm = cur[1] + dy[i];
                    if (0 <= nn && nn < n && 0 <= nm && nm < m) {
                        if (!visit[nn][nm] && map[nn][nm] != 0) {
                            queue.add(new int[]{nn, nm});
                            visit[nn][nm] = true;
                        }
                    }
                }

            }
            return returnValue;
        }
    }
}
