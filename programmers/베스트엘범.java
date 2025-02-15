package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트엘범 {

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<Integer>> genreMap = new HashMap<>();
            Map<String, Integer> sumMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                if (genreMap.containsKey(genres[i])) {
                    genreMap.get(genres[i]).add(i);
                    sumMap.put(genres[i], sumMap.get(genres[i]) + plays[i]);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    genreMap.put(genres[i], list);
                    sumMap.put(genres[i], plays[i]);
                }
            }

            List<String> keyList = new ArrayList<>(sumMap.keySet());
            keyList.sort((a, b) -> sumMap.get(b) - sumMap.get(a));
            List<Integer> answer = new ArrayList<>();
            for (String genre : keyList) {
                List<Integer> tmp = genreMap.get(genre);
                tmp.sort((o1, o2) -> {
                    if (plays[o1] == plays[o2]) {
                        return o1 - o2;
                    }
                    return plays[o2] - plays[o1];
                });
                for (int i = 0; i < Math.min(tmp.size(), 2); i++) {
                    answer.add(tmp.get(i));
                }
            }
            int[] ans = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                ans[i] = answer.get(i);
            }
            return ans;
        }
    }
}
