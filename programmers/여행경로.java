package programmers;

import java.util.*;

public class 여행경로 {

    class Solution {

        public List<String> list = new ArrayList<>();
        public Map<String, Queue<String>> map;
        public boolean find = false;

        public String[] solution(String[][] tickets) {
            map = new HashMap<>();
            for (String[] tic : tickets) {
                if (map.containsKey(tic[0])) {
                    map.get(tic[0]).add(tic[1]);
                } else {
                    map.put(tic[0], new LinkedList<>());
                    map.get(tic[0]).add(tic[1]);
                }
            }

            for (String key : map.keySet()) {
                List<String> tmp = new ArrayList<>(map.get(key));
                Collections.sort(tmp);
                map.get(key).clear();
                map.get(key).addAll(tmp);
            }


            dfs(new ArrayList<>(), "ICN", tickets.length);

            String[] answer = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }

        public void dfs(List<String> trav, String dep, int remain) {
            if (find) {
                return;
            }

            trav.add(dep);
            if (remain == 0) {
                list = trav;
                find = true;
                return;
            }
            if (!map.containsKey(dep)) {
                return;
            }


            for (int i = 0; i < map.get(dep).size(); i++) {
                String arr = map.get(dep).poll();
                dfs(new ArrayList<>(trav), arr, remain - 1);
                map.get(dep).add(arr);
            }
        }
    }
}
