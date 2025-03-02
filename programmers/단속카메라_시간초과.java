package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단속카메라_시간초과 {

    class Solution {
        public int solution(int[][] routes) {

            List<int[]> list = new ArrayList<>();
            Collections.addAll(list, routes);

            list.sort((o1, o2) -> {
                return Integer.compare((o1[1] - o1[0]), (o2[1] - o2[0]));
            });


            List<int[]> camera = new ArrayList<>();

            for (int[] tmp : list) {
                boolean flag = false;
                for (int[] cTmp : camera) {
                    if (cTmp[1] < tmp[0] || cTmp[0] > tmp[1]) {
                        continue;
                    }
                    cTmp[0] = Math.max(cTmp[0], tmp[0]);
                    cTmp[1] = Math.min(cTmp[1], tmp[1]);
                    flag = true;
                }
                if (!flag) {
                    camera.add(tmp);
                }
            }
            return camera.size();
        }
    }
}
