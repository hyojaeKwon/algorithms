import java.io.*;
import java.util.*;

public class BOJ_1450 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int[] items = new int[number+1];
        items[0] = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < number; i++){
            items[i+1] = Integer.parseInt(st.nextToken());
        }
        //        int[][] dp = new int[capacity+1][number];
        int[][] dp = new int[number+1][capacity+1];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i <= number; i++){
            for(int j = 1; j <= capacity; j++){
                if (items[i] < j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i-1][j-items[i]] = dp[i-1][j] + 1;
                }
            }
        }
        bw.write(dp[number][capacity] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
