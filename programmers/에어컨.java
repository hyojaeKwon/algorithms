package programmers;

import java.util.*;

class 에어컨 {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] dp = new int[onboard.length][51];
        int MAX_VALUE = 1000 * 100 + 1;
        t1 += 10;
        t2 += 10;
        temperature += 10;

        for(int i = 0 ; i < onboard.length ; i ++){
            Arrays.fill(dp[i], MAX_VALUE);
        }
        dp[0][temperature] = 0;

        int isCold = 1;
        if(temperature >  t2) {
            isCold = -1;
        }

        for(int i = 1 ; i < onboard.length ; i ++){

            for(int j = 0 ; j < 51 ; j ++){
                int min = MAX_VALUE;

                if(onboard[i] == 0 || (onboard[i] == 1 && j <= t2 && j >= t1)){
                    // 에어컨 키는 경우
                    // 온도 일치
                    if(t1 <= j && j <= t2){
                        min = Math.min(min, dp[i-1][j] + b);
                    }
                    // 온도 불일치
                    if(0 <= j - isCold && j - isCold <= 50){
                        min = Math.min(min, dp[i-1][j - isCold] + a);
                    }


                    // 에어컨 끄는 경우
                    // 실외온도 불일치
                    if(0 <= j + isCold && j + isCold <= 50){
                        min = Math.min(min, dp[i -1][j + isCold]);
                    }
                    // 실외온도 일치
                    if(j == temperature){
                        min = Math.min(min, dp[i-1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        for(int i = 0 ; i < 51 ; i++){
            MAX_VALUE = Math.min(dp[onboard.length - 1][i],MAX_VALUE);
        }


        return MAX_VALUE;
    }
}