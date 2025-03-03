package programmers;

public class 네트워크 {
    class Solution {
        boolean[] visit;

        public int solution(int n, int[][] computers) {
            visit = new boolean[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(i, computers);
                    count++;
                }
            }
            return count;
        }

        public void dfs(int current, int[][] map) {
            for (int i = 0; i < map.length; i++) {
                if (current == i) continue;
                if (!visit[i] && map[current][i] == 1) {
                    visit[i] = true;
                    dfs(i, map);
                }
            }
        }
    }
}
