package programmers;

import java.util.PriorityQueue;

public class 더맵게 {

    class Solution {
        public int solution(int[] scoville, int K) {

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int j : scoville) {
                pq.add((long) j);
            }

            int time = 0;
            while (pq.size() >= 2) {
                if (pq.peek() >= K) return time;
                time++;
                long score = pq.poll() + pq.poll() * 2;
                pq.add(score);
            }

            if (pq.peek() >= K) return time;
            return -1;
        }
    }

}
