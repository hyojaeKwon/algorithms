package programmers;

import java.util.Arrays;

public class HIndex {

    class Solution {
        public int solution(int[] citations) {
            Integer[] cList = Arrays.stream(citations).boxed().toArray(Integer[]::new);

            Arrays.sort(cList, (o1, o2) -> o2 - o1);
            int length = cList.length;
            int hIndex = 0;
            for (int i = 0; i < length; i++) {
                int cur = cList[i];
                if (cur >= i + 1 && length - i - 1 <= cur) {
                    hIndex = i + 1;
                }
            }
            return hIndex;
        }
    }
}
