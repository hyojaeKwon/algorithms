package programmers;

public class 입국심사 {
    class Solution {
        public long solution(int n, int[] times) {
            long start = 1;
            long end = 1_000_000_000L * n;

            while (start <= end) {
                long mid = (start + end) / 2;

                long avail = 0;
                for (int i : times) {
                    avail += mid / i;
                    if (avail >= n) break;
                }

                if (avail >= n) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;

        }
    }
}
