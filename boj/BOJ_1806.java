import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int sum = 0;

        while (r <= n) {
            if (sum >= m) {
                min = Math.min(min, r - l );
                sum -= arr[l++];
            } else {
                sum += arr[r++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);


    }
}