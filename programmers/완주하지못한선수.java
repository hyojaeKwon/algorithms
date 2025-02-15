package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> hashMap = new HashMap<>();
            for (String name : participant) {
                if (hashMap.containsKey(name)) {
                    hashMap.compute(name, (k, num) -> num + 1);
                    continue;
                }
                hashMap.put(name, 1);
            }
            for (String name : completion) {
                int num = hashMap.get(name);
                if (num == 1) {
                    hashMap.remove(name);
                } else {
                    hashMap.put(name, num - 1);
                }
            }

            return hashMap.keySet().iterator().next();

        }
    }
}
