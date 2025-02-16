import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1509 {

    private static int[] dp;
    private static char[] table;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            String[] inputArray = input.split("");
            dp = new int[input.length() + 1];
            table = new char[input.length() + 1];

            for (int i = 1; i < dp.length; i++) {
                dp[i] = i;
                table[i] = inputArray[i - 1].charAt(0);
            }
            dp[0] = 0;

            find();
            System.out.println(dp[dp.length - 1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void find() {
        for (int i = 2; i < table.length; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (int j = 1; j < i; j++) {
                if (isPalindrome(j, i)) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
    }

    private static boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (table[start] != table[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
