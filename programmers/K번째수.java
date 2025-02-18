package programmers;

import java.util.Arrays;

public class K번째수 {

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int[] cc = commands[i];
                int[] curArr = new int[cc[1] - cc[0] + 1];
                if (cc[1] + 1 - cc[0] >= 0)
                    System.arraycopy(array, cc[0] - 1, curArr, 0, cc[1] + 1 - cc[0]);
                Arrays.sort(curArr);
                answer[i] = curArr[cc[2] - 1];
            }

            return answer;
        }
    }
}
