package programmers;

import java.util.Arrays;


public class 시소짝궁 {

    class Solution {
        public long solution(int[] weights) {
            long answer = 0;

            int[] weightList = new int[1001];
            Arrays.fill(weightList, 0);

            for(int weight : weights){
                weightList[weight] += 1;
            }

            for(int i = 100 ; i < weightList.length ; i++){
                if(weightList[i] == 0) continue;

                if(weightList[i] >= 2){
                    long value = ((long)weightList[i] * ((long)weightList[i]-1)) / 2L;
                    answer = answer + value;
                }
                int[] val = {1,2,3};

                for(int value : val){
                    if(i%value == 0){
                        int toVal = (i/value)*(value+1);
                        if(toVal > 1000) continue;
                        long tmp = (long)weightList[i] * (long)weightList[toVal];
                        answer += tmp;
                    }
                }
            }


            return answer;
        }
    }
}
