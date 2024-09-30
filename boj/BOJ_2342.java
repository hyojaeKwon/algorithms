import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2342 {
    private static int[] input;
    private static int[][][] dp;
    private static final int MAX_VALUE = 100000 * 4 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[st.countTokens()];
        input[0] = 0;

        for (int i = 1; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[5][5][input.length];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < input.length; k++) {
                    dp[i][j][k] = MAX_VALUE;
                }
            }
        }
        if(input.length == 1) System.out.println(0);
        else System.out.println(solve());
    }

    private static int solve() {
        dp[0][0][0] = 0;
        for(int i = 1 ; i < input.length ; i++) {
            int next = input[i];
            for(int j = 0 ; j < 5 ; j++) {
                for(int k = 0 ; k < 5 ; k++) {
                    dp[j][next][i] = Math.min(dp[j][next][i], dp[j][k][i - 1] + calPower(k, next));
                    dp[next][k][i] = Math.min(dp[next][k][i], dp[j][k][i - 1] + calPower(j, next));
                }
            }
        }

        int last = input[input.length - 1];
        int answer = MAX_VALUE;
        for(int i = 0 ; i < 5 ; i++) {
            answer = Math.min(dp[i][last][input.length-1], answer);
            answer = Math.min(dp[last][i][input.length-1], answer);
        }
        return answer;
    }

    private static int calPower(int from, int to) {
        if(from == to) return 1;
        else if(from == 0) return 2;
        else if(Math.abs(from - to) % 2 == 1) return 3;
        else return 4;
    }

}
