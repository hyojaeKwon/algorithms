import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        int[] memories = new int[N];
        int[] values = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            memories[i] = Integer.parseInt(st1.nextToken());
            values[i] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[N][10001];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < 10001; j++) {
                if (i == 0) {
                    if(j >= values[i]) {
                        dp[i][j] = memories[i];
                    }
                } else {
                    if(j >= values[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - values[i]] + memories[i]);
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if(dp[i][j] >= target) {
                    min = Math.min(min, j);
                }
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
