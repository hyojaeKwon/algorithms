package programmers;

import java.util.Arrays;

public class 구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int count = 0;
            int idx = people.length - 1;
            for (int i = 0; i <= idx; i++) {
                if (people[i] + people[idx] <= limit) {
                    count++;
                    idx--;
                } else {
                    count++;
                    idx--;
                    i--;
                }
            }
            return count;
        }
    }
}
