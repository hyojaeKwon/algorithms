package programmers;

import java.util.*;

public class 디스크컨트롤러 {

    class Solution {
        public int solution(int[][] jobs) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

            int count = 0;
            int jobIdx = 0;
            int time = jobs[jobIdx][0];
            pq.add(jobs[jobIdx++]);
            List<Integer> waits = new ArrayList<>();

            while (count < jobs.length) {
                while (jobIdx < jobs.length && jobs[jobIdx][0] <= time) {
                    pq.add(jobs[jobIdx++]);
                }
                if (pq.isEmpty()) {
                    time = jobs[jobIdx][0];
                    continue;
                }

                int[] cur = pq.poll();
                if (time < cur[0]) {
                    time = cur[0];
                }
                time += cur[1];
                waits.add(time - cur[0]);
                count++;


            }
            int sum = waits.stream().reduce(0, Integer::sum);
            int answer = sum / waits.size();
            return answer;
        }
    }
}
