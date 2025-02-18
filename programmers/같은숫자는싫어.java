package programmers;

import java.util.*;

public class 같은숫자는싫어 {

    public class Solution {
        public int[] solution(int []arr) {
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();

            for(int i = 0 ; i < arr.length ; i++){
                queue.add(arr[i]);
            }

            ans.add(queue.poll());

            while(!queue.isEmpty()){
                int num = queue.poll();
                if(num != ans.get(ans.size() - 1)){
                    ans.add(num);
                }
            }

            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
