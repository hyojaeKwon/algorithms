import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {


    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int max = Integer.MAX_VALUE;

            int minL = 0;
            int minR = 0;
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int value = arr[left] + arr[right];

                if (max > Math.abs(value)) {
                    max = Math.abs(value);
                    minL = left;
                    minR = right;
                }
                if (value > 0) {
                    right--;
                } else {
                    left++;
                }

            }
            bw.write(arr[minL] + " " + arr[minR] + "\n");
        }
    }
}
