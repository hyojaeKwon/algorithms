package programmers;

import java.util.*;

public class 하노이의탑 {

    public class Solution {
        public int[][] solution(int n) {

            List<Integer[]> answer = new ArrayList<>();
            hanoi(1, 3, 2, n, answer);
            int[][] ans = new int[answer.size()][2];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = new int[]{answer.get(i)[0], answer.get(i)[1]};
            }

            List<Integer> a = new ArrayList<>();
            a.sort(Comparator.naturalOrder());
            return ans;
        }



        public void hanoi(int start, int end, int middle, int n, List<Integer[]> answer) {
            if (n == 1) {
                answer.add(new Integer[]{start, end});
                return;
            }

            hanoi(start, middle, end, n - 1, answer);
            answer.add(new Integer[]{start, end});
            hanoi(middle, end, start, n - 1, answer);
        }
    }
}
