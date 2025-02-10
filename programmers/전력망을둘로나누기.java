package programmers;

public class 전력망을둘로나누기 {
    class Solution {
        private int size;

        private int answer = 100;
        private boolean[][] map;
        private boolean[] visit;

        public int solution(int n, int[][] wires) {
            size = n;

            map = new boolean[size + 1][size + 1];

            for (int[] wire : wires) {
                map[wire[0]][wire[1]] = true;
                map[wire[1]][wire[0]] = true;
            }

            for (int[] wire : wires) {
                visit = new boolean[size + 1];
                visit[wire[1]] = true;
                int result = dfs(wire[0]);
                answer = Math.min(answer, Math.abs(size - 2 * result));
            }

            return answer;
        }

        private int dfs(int point) {
            visit[point] = true;
            int tmp = 1;
            for (int i = 1; i <= size; i++) {
                if (map[point][i] && !visit[i]) {
                    tmp += dfs(i);
                }
            }
            return tmp;
        }
    }
}
