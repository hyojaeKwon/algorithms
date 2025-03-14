package programmers;

import java.util.*;

public class 양과늑대 {

    class Solution {
        public int solution(int[] info, int[][] edges) {
            int n = info.length;
            List<Integer>[] tree = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                tree[edge[0]].add(edge[1]);
            }


            Queue<State> queue = new LinkedList<>();
            queue.add(new State(0, 0, 0, new HashSet<>(List.of(0))));

            int answer = 0;

            while (!queue.isEmpty()) {
                State current = queue.poll();
                answer = Math.max(current.sheep, answer);
                for (int next : current.canVisit) {
                    HashSet<Integer> set = new HashSet<>(current.canVisit);
                    set.remove(next);
                    set.addAll(tree[next]);
                    if (info[next] == 0) {
                        queue.add(new Stxate(next, current.sheep + 1, current.wolf, set));
                    } else if (current.sheep > current.wolf + 1) {
                        queue.add(new State(next, current.sheep, current.wolf + 1, set));
                    }
                }
            }

            return answer;
        }

        class State {
            int node, sheep, wolf;
            Set<Integer> canVisit;

            State(int node, int sheep, int wolf, Set<Integer> canVisit) {
                this.node = node;
                this.sheep = sheep;
                this.wolf = wolf;
                this.canVisit = canVisit;
            }
        }

    }
}
