import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17070 {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int n = Integer.parseInt(br.readLine());

            int[][][] dp = new int[3][n][n];
            boolean[][] map = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().equals("0");
                }
            }

            dp[0][0][1] = 1;
            for(int i = 2; i < n; i++) {
                if (map[0][i]) {
                    dp[0][0][i] = dp[0][0][i-1];
                } else break;
            }

            for(int i = 1; i < n; i++) {
                for(int j = 1; j < n; j++) {
                    if(!map[i][j]) {
                        continue;
                    }
                    dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
                    dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

                    if (map[i - 1][j] && map[i][j - 1]) {
                        dp[2][i][j] = dp[2][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[0][i - 1][j - 1];
                    }
                }
            }
            int ans = dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1];
            bw.write(Integer.toString(ans));
        }

    }
}
