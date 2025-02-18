package programmers;

import java.util.Stack;

public class 주식가격 {

    class Solution {
        public int[] solution(int[] prices) {
            int[] ans = new int[prices.length];

            Stack<int[]> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                if (stack.isEmpty()) {
                    stack.add(new int[]{prices[i], i});
                    continue;
                }

                while (!stack.isEmpty()) {
                    if (stack.peek()[0] <= prices[i]) {
                        break;
                    }
                    int[] cur = stack.pop();
                    ans[cur[1]] = i - cur[1];
                }
                stack.add(new int[]{prices[i], i});
            }

            while (!stack.isEmpty()) {
                int[] cur = stack.pop();
                ans[cur[1]] = prices.length - 1 - cur[1];
            }
            return ans;
        }
    }
}
