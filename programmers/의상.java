package programmers;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();

            for (String[] curClo : clothes) {
                if (map.containsKey(curClo[1])) {
                    map.put(curClo[1], map.get(curClo[1]) + 1);
                    continue;
                }
                map.put(curClo[1], 1);
            }

            int answer = 1;
            for (int i : map.values()) {
                answer *= (i + 1);
            }

            return answer - 1;
        }
    }
}
