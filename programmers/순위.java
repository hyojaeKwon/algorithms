package programmers;

public class 순위 {

    class Solution {
        public int solution(int n, int[][] results) {

            boolean[][] map = new boolean[n][n];

            // 선수 간의 관계 정상화
            for (int[] result : results) {
                map[result[0] - 1][result[1] - 1] = true;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (map[i][k]) {
                        for (int j = 0; j < n; j++) {
                            if (map[k][j]) {
                                map[i][j] = true;
                            }
                        }
                    }
                }
            }

            // 합이 n - 1 인 선수의 수 반환
            int answer = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] || map[j][i]) {
                        count++;
                    }
                }
                if (count == (n - 1)) {
                    answer++;
                }
            }
            return answer;
        }

    }
}
