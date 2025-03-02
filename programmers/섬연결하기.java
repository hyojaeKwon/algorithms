package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬연결하기 {

    // MST -> 크루스칼 알고리즘
    class Solution {

        public int[] parent;

        public int solution(int n, int[][] costs) {
            if (n == 1) return 0;

            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }

            List<int[]> bridge = new ArrayList<>();
            Collections.addAll(bridge, costs);

            Collections.sort(bridge, (o1, o2) -> {
                return Integer.compare(o1[2], o2[2]);
            });

            int cost = 0;
            for (int i = 0; i < bridge.size(); i++) {
                int[] tmp = bridge.get(i);
                if (find(tmp[0]) != find(tmp[1])) {
                    cost += tmp[2];
                    union(tmp[1], tmp[0]);
                }
            }

            return cost;
        }

        public void union(int x, int y) {
            int xp = find(x);
            int yp = find(y);

            if (xp > yp) {
                parent[xp] = yp;
                return;
            }
            parent[yp] = xp;
        }

        public int find(int target) {
            if (parent[target] == target) {
                return target;
            }
            return find(parent[target]);
        }
    }
}
