package programmers;

public class 올바른괄호의갯수 {
    class Solution {
        int count = 0;

        public int solution(int n) {
            return solve(n);
        }

        public int solve(int rest) {
            if (rest <= 1) return 1;

            int result = 0;
            for (int i = 1; i <= rest; i++) {
                result += (solve(i - 1) * solve(rest - i));
            }
            return result;
        }
    }
}
