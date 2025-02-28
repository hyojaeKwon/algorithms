package programmers;

import java.util.HashSet;
import java.util.Set;

public class 체육복 {

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            Set<Integer> lostSet = new HashSet<>();
            Set<Integer> reserveSet = new HashSet<>();

            for (int i : lost) {
                lostSet.add(i);
            }
            for (int i : reserve) {
                if (lostSet.contains(i)) {
                    lostSet.remove(i);
                } else {
                    reserveSet.add(i);
                }
            }

            int avail = n - lostSet.size();

            for (int i : new HashSet<>(lostSet)) {
                if (reserveSet.contains(i - 1)) {
                    reserveSet.remove(i - 1);
                    lostSet.remove(i);
                    avail++;
                } else if (reserveSet.contains(i + 1)) {
                    reserveSet.remove(i + 1);
                    lostSet.remove(i);
                    avail++;
                }
            }
            return avail;
        }
    }
}
