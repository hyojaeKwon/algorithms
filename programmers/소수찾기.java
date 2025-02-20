package programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    class Solution {

        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int length;
        String[] sol;
        boolean[] visit;

        public int solution(String numbers) {
            sol = numbers.split("");
            length = sol.length;
            visit = new boolean[length];
            pick("");
            return set.size();
        }

        public void pick(String target) {

            if (!target.isEmpty()) {
                int num = Integer.parseInt(target);
                if (isPrime(num)) {
                    set.add(num);
                }
            }

            for (int i = 0; i < length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    pick(target + sol[i]);
                    visit[i] = false;
                }
            }
        }

        public boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }
}
