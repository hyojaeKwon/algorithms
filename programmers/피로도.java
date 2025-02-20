package programmers;

public class 피로도 {
    class Solution {
        int max = 0;
        boolean[] visit;

        public int solution(int k, int[][] dungeons) {
            visit = new boolean[dungeons.length];
            solution(k, dungeons, 0);
            return max;
        }

        public void solution(int cur, int[][] dungeons, int times) {

            for (int i = 0; i < dungeons.length; i++) {
                if (!visit[i] && cur >= dungeons[i][0]) {
                    visit[i] = true;
                    solution(cur - dungeons[i][1], dungeons, times + 1);
                    visit[i] = false;
                }
            }

            max = Math.max(times, max);
        }


    }
}
