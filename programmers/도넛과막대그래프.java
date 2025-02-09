package programmers;

public class 도넛과막대그래프 {

    static class Solution {
        public int[] solution(int[][] edges) {
            int[] answer = new int[]{0, 0, 0, 0};

            int size = 0;
            for (int[] edge : edges) {
                size = Math.max(size, Math.max(edge[0], edge[1]));
            }
            int[] input = new int[size];
            int[] output = new int[size];

            for (int[] edge : edges) {
                input[edge[1] - 1]++;
                output[edge[0] - 1]++;
            }
            int origin = 0;

            for (int i = 0; i < size; i++) {
                if (input[i] == 0 && output[i] >= 2) {
                    answer[0] = i + 1;
                    origin = i;
                }
                if ((input[i] >= 1 && output[i] == 0)) {
                    answer[2]++;
                }
                if (input[i] >= 2 && output[i] == 2) {
                    answer[3]++;
                }
            }
            answer[1] = output[origin] - answer[2] - answer[3];

            return answer;
        }
    }
}
