package programmers;

public class 등굣길 {

    class Solution {

        int mod = 1_000_000_007;

        public int solution(int m, int n, int[][] puddles) {
            int[][] map = new int[n][m];

            for (int[] puddle : puddles) {
                map[puddle[1] - 1][puddle[0] - 1] = -1;
            }

            for (int i = 0; i < m; i++) {
                if (map[0][i] == -1) {
                    break;
                }
                map[0][i] = 1;
            }

            for (int i = 0; i < n; i++) {
                if (map[i][0] == -1) {
                    break;
                }
                map[i][0] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (map[j][i] == -1) {
                        continue;
                    }
                    int up;
                    int left;
                    if (map[j - 1][i] == -1) {
                        up = 0;
                    } else {
                        up = map[j - 1][i];
                    }

                    if (map[j][i - 1] == -1) {
                        left = 0;
                    } else {
                        left = map[j][i - 1];
                    }

                    map[j][i] = (up + left) % mod;
                }
            }

            return map[n - 1][m - 1];
        }
    }
}
