package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            Map<Integer, Integer> count = new HashMap<>();

            for (String oper : operations) {
                String[] opers = oper.split(" ");
                String command = opers[0];
                int num = Integer.parseInt(opers[1]);

                if (command.equals("I")) {
                    minHeap.add(num);
                    maxHeap.add(num);
                    count.put(num, count.getOrDefault(num, 0) + 1);
                } else {
                    if (count.isEmpty()) continue;

                    if (num == 1) removeValid(maxHeap, count);
                    else removeValid(minHeap, count);
                }
            }

            if (count.isEmpty()) {
                return new int[]{0, 0};
            }
            int min = getValidTop(minHeap, count);
            int max = getValidTop(maxHeap, count);
            return new int[]{max, min};
        }

        private int removeValid(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
            while (!heap.isEmpty()) {
                int num = heap.poll();
                if (count.getOrDefault(num, 0) > 0) {
                    count.put(num, count.get(num) - 1);
                    if (count.get(num) == 0) count.remove(num);
                    return num;
                }
            }
            return 0;
        }

        private int getValidTop(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (count.getOrDefault(num, 0) > 0) {
                    return num;
                } else {
                    heap.poll();
                }
            }
            return 0;
        }
    }
}
