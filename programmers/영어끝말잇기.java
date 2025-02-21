package programmers;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {};

            Set<String> set = new HashSet<>();

            if (words[0].length() <= 1) {
                return new int[]{1, 1};
            }
            set.add(words[0]);

            for (int i = 1; i < words.length; i++) {
                String prev = words[i - 1];
                String cur = words[i];
                if (cur.length() <= 1 || prev.charAt(prev.length() - 1) != cur.charAt(0) || set.contains(cur)) {
                    int who = (i + 1) % n;
                    if (who == 0) who = n;
                    int times = (int) Math.ceil((i + 1) / (double) n);
                    return new int[]{who, times};
                }
                set.add(cur);
            }

            return new int[]{0, 0};
        }
    }
}
