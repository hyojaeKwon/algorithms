package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {

    class Solution {
        public int solution(int n, int[][] edge) {

            int[] map = new int[n];
            boolean[] visit = new boolean[n];
            List<Integer>[] edges = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] e : edge) {
                edges[e[0] - 1].add(e[1] - 1);
                edges[e[1] - 1].add(e[0] - 1);
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visit[0] = true;
            map[0] = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int to : edges[cur]) {
                    if (!visit[to]) {
                        map[to] = map[cur] + 1;
                        queue.add(to);
                        visit[to] = true;
                    }
                }
            }

            int max = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, map[i]);
            }
            for (int i = 0; i < n; i++) {
                if (map[i] == max) {
                    count += 1;
                }
            }

            return count;
        }
    }
}
