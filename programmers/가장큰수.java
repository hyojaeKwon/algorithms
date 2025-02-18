package programmers;

import java.util.*;
public class 가장큰수 {

    class Solution {
        public String solution(int[] numbers) {
            String[] newArr = new String[numbers.length];
            for(int i = 0 ; i < numbers.length ; i++){
                newArr[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(newArr, (o1, o2) -> {
                int o1o2 = Integer.parseInt(o1 + o2);
                int o2o1 = Integer.parseInt(o2 + o1);
                return Integer.compare(o2o1, o1o2);
            });

            Arrays.sort(newArr, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for(String str: newArr){
                sb.append(str);
            }

            if(sb.toString().startsWith("0")) return "0";
            return sb.toString();
        }
    }
}
