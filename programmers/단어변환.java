package programmers;

import java.util.HashMap;
import java.util.Map;

public class 단어변환 {

    class Solution {
        private int min = 51;

        public int solution(String begin, String target, String[] words) {
            boolean[] visit = new boolean[words.length];
            dfs(visit, begin, target, 0, words);
            if (min == 51) return 0;
            return min;
        }

        private void dfs(boolean[] wordsVisit, String current, String target, int depth, String[] words) {

            if (current.equals(target)) {
                min = Math.min(depth, min);
                return;
            }

            Map<Integer, String> findResult = find(current, words, wordsVisit);

            for (Integer key : findResult.keySet()) {
                wordsVisit[key] = true;
                boolean[] curVisit = wordsVisit;
                dfs(curVisit, findResult.get(key), target, depth + 1, words);
                wordsVisit[key] = false;
            }
        }

        private Map<Integer, String> find(String now, String[] words, boolean[] visit) {
            Map<Integer, String> simWords = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (isSimWord(now, words[i]) && !visit[i]) {
                    simWords.put(i, words[i]);
                }
            }
            return simWords;
        }

        private boolean isSimWord(String cur, String tar) {
            int diff = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != tar.charAt(i)) {
                    diff++;
                }
            }
            return diff <= 1;
        }
    }
}
