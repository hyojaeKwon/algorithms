package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현 {

    class Solution {
        public int solution(int N, int number) {

            if (N == number) return 1;
            List<Set<Integer>> dp = new ArrayList<>();
            for (int i = 0; i <= 8; i++) {
                dp.add(new HashSet<>());
            }
            dp.get(1).add(N);

            for (int i = 2; i <= 8; i++) {
                int num = Integer.parseInt(String.valueOf(N).repeat(i));
                dp.get(i).add(num);

                for (int j = 1; j < i; j++) {
                    for (int a : dp.get(j)) {
                        for (int b : dp.get(i - j)) {
                            dp.get(i).add(a + b);
                            dp.get(i).add(a - b);
                            dp.get(i).add(a * b);
                            if (b != 0) dp.get(i).add(a / b);
                        }
                    }
                }
                if (dp.get(i).contains(number)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
