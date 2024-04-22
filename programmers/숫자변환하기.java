package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class 숫자변환하기 {

    class Solution {

        private static int[] dp;
        private static boolean[] visit;
        private static int maxRange;
        public int solution(int x, int y, int n) {
            maxRange = y + 1;

            dp = new int[maxRange];
            Arrays.fill(dp, 0);

            for(int i = x ; i < maxRange ; i++){
                if( i != x && dp[i] == 0){
                    dp[i] = -1;
                    continue;
                }
                if( i + n <= y){
                    if(dp[i + n] == 0){
                        dp[i+n] = dp[i] + 1;
                    }
                    else {
                        dp[i+n] = Math.min(dp[i+n], dp[i] + 1);
                    }
                }
                if( i * 2 <= y){
                    if(dp[i * 2] == 0){
                        dp[i * 2] = dp[i] + 1;
                    }
                    else {
                        dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
                    }
                }
                if( i * 3 <= y){
                    if(dp[i * 3] == 0){
                        dp[i * 3] = dp[i] + 1;
                    }
                    else {
                        dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
                    }
                }
            }

            return dp[y];

        }



    }
}
