package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<int[]> queue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < speeds.length; i++) {
                queue.add(new int[]{progresses[i], i});
            }

            int time = 0;
            while (!queue.isEmpty()) {
                int remainProgress = 100 - queue.peek()[0];
                int remainTime = remainProgress / speeds[queue.peek()[1]];
                if (remainProgress % speeds[queue.peek()[1]] != 0) remainTime++;

                int count = 0;
                while (!queue.isEmpty()) {
                    int[] cur = queue.peek();
                    if (remainTime * speeds[cur[1]] + cur[0] >= 100) {
                        queue.poll();
                        count++;
                    } else {
                        break;
                    }
                }
                if (count != 0) list.add(count);
            }

            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;

        }
    }
}
