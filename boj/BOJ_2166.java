import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }


        // 0번 기준점
        long[] origin = arr[0];
        double ans = 0.0;
        arr[1][0] -= origin[0];
        arr[1][1] -= origin[1];

        for(int i = 1; i < n-1; i++) {
            arr[i + 1][0] -= origin[0];
            arr[i + 1][1] -= origin[1];

            ans += (arr[i][0] * arr[i + 1][1] - arr[i][1] * arr[i + 1][0]) / 2.0;
        }
        ans = Math.abs(ans);

        bw.write(String.format("%.1f", ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
