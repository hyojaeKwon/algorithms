package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단속카메라 {

    class Solution {
        public int solution(int[][] routes) {

            List<int[]> list = new ArrayList<>();
            Collections.addAll(list, routes);

            list.sort(Comparator.comparingInt(o -> o[1]));

            List<Integer> camera = new ArrayList<>();

            for (int[] tmp : list) {
                if (camera.isEmpty()) {
                    camera.add(tmp[1]);
                    continue;
                }
                if (camera.getLast() < tmp[0]) {
                    camera.add(tmp[1]);
                }

            }
            return camera.size();
        }
    }
}
