import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2098 {
    private static final int MAX = 16 * 1_000_000 + 1;
    private static int bitmaskRange;
    private static int n;
    private static int[][] map;
    private static int[][] dp;

    public static void main(String[] args) {
        initialize();
        System.out.println(solve(0,1));
    }

    private static int solve(int cur, int visited) {
        if (visited == ((1 << n) - 1)) {
            return map[cur][0] != 0 ? map[cur][0] : -1;
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = MAX;
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) != 0 || (map[cur][i] == 0)) {
                continue;
            }
            int minDistance = solve(i, visited | (1 << i));
            if (minDistance != -1) {
                dp[cur][visited] = Math.min(dp[cur][visited], map[cur][i] + minDistance);
            }
        }
        return dp[cur][visited];
    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bitmaskRange = 1 << n;
            dp = new int[n][bitmaskRange];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < bitmaskRange; j++) {
                    dp[i][j] = -1;
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
