package programmers;

public class 정수삼각형 {

    class Solution {
        public int solution(int[][] triangle) {

            int[] ans = new int[triangle.length];
            ans[0] = triangle[0][0];

            for (int i = 1; i < triangle.length; i++) {
                int[] tmp = new int[i + 1];
                for (int j = 0; j < i + 1; j++) {
                    int now = triangle[i][j];
                    if (j == 0) {
                        tmp[j] = now + ans[0];
                        continue;
                    }
                    if (j == i) {
                        tmp[j] = now + ans[i - 1];
                        continue;
                    }
                    tmp[j] = Math.max(now + ans[j], now + ans[j - 1]);
                }
                System.arraycopy(tmp, 0, ans, 0, i + 1);
            }

            int maxVal = 0;
            for (int tmp : ans) {
                maxVal = Math.max(maxVal, tmp);
            }
            return maxVal;
        }
    }
}
