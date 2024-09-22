package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461{
    
   
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        
        for (int i = 6 ; i <= 100 ; i++){
            dp[i] = dp[i-1] + dp [i-5];
        }
        
        for(int i = 0 ; i < n ; i ++){
            
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k]);
        }
    }
   
}
