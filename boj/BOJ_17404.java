import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17404 {
    static final int MAX = 1001 * 1001 + 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = MAX;
        for(int firstColor = 0 ; firstColor < 3 ; firstColor++) {
            int minCostPaint = getMinCostPaint(n, input, firstColor);
            ans = Math.min(ans, minCostPaint);
        }

        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getMinCostPaint(int n, int[][] input, int firstColor) {
        int[] dp = new int[3];
        int[] prevDp = new int[3];

        for(int i = 0; i < 3; i++) {
            if (i == firstColor) {
                prevDp[i] = input[0][i];
            } else {
                prevDp[i] = MAX;
            }
        }

        for(int i = 1; i < n; i++) {
            dp[0] = Math.min(prevDp[1], prevDp[2]) + input[i][0];
            dp[1] = Math.min(prevDp[0], prevDp[2]) + input[i][1];
            dp[2] = Math.min(prevDp[1], prevDp[0]) + input[i][2];

            System.arraycopy(dp, 0, prevDp, 0, 3);
        }

        int res = MAX;
        for(int i = 0; i < 3; i++) {
            if(i != firstColor) {
                res = Math.min(res, prevDp[i]);
            }
        }
        return res;


    }
}
