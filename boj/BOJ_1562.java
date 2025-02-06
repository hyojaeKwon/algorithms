import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1562 {

    public static final int MOD = 1_000_000_000;
    public static final int BITMASK_RANGE = 1024;
    public static final int NUMBER_RANGE = 10;
    private static int n;
    private static int[][][] dp;

    public static void main(String[] args) {
        inputInitialize();
        solve();
    }

    private static void solve() {
        for (int i = 1; i < NUMBER_RANGE; i++) {
            dp[0][i][1 << i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < NUMBER_RANGE; j++) {
                for (int k = 0; k < BITMASK_RANGE; k++) {
                    if (j - 1 >= 0) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                    }
                    if (j + 1 < NUMBER_RANGE) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                    }
                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < NUMBER_RANGE; i++) {
            ans += dp[n - 1][i][BITMASK_RANGE - 1];
            ans %= MOD;
        }
        System.out.println(ans);
    }

    private static void inputInitialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dp = new int[n][NUMBER_RANGE][BITMASK_RANGE];
    }
}
