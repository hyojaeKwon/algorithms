package programmers;

import java.util.Arrays;

public class 징검다리 {

    class Solution {
        public int solution(int distance, int[] rocks, int n) {
            int[] disDiff = new int[rocks.length + 1];
            int start = 1;
            int end = distance;
            Arrays.sort(rocks);
            disDiff[0] = rocks[0];
            for (int i = 1; i < rocks.length; i++) {
                disDiff[i] = rocks[i] - rocks[i - 1];
            }
            disDiff[rocks.length] = distance - rocks[rocks.length - 1];

            while (start <= end) {
                int mid = (start + end) / 2;
                int[] tmp = disDiff.clone();
                int count = 0;
                for (int i = 0; i <= rocks.length; i++) {
                    if (tmp[i] <= mid) {
                        count++;
                        if (i != rocks.length) {
                            tmp[i + 1] += tmp[i];
                        }
                    }
                }
                if (count > n) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}
