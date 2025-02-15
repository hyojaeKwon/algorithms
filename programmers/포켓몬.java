package programmers;

import java.util.*;

public class 포켓몬 {
    class Solution {
        public int solution(int[] nums) {
            Set<Integer> map = new HashSet<>();
            for (int target : nums) {
                map.add(target);
            }
            return Math.min(nums.length / 2, map.size());
        }
    }
}
