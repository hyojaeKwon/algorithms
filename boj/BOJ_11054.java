import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        // 앞에서 뒤로가면서 가장 증가하는거 찾고
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0]) {
                    arr[i][1] = Math.max(arr[i][1], arr[j][1] + 1);
                }
            }
        }

        // 뒤에서 앞으로 가면서 가장 감소하는 거 찾고
        for(int i = n - 2 ; i >= 0 ; i--) {
            for(int j = n - 1; j > i; j--) {
                if (arr[j][0] < arr[i][0]) {
                    arr[i][2] = Math.max(arr[i][2], arr[j][2] + 1);
                }
            }
        }
        int result = 0;
        // 둘이 더하면 답 아잉교
        for(int i = 0; i < n; i++) {
            int tmp = arr[i][1] + arr[i][2];
            if(tmp > result) {
                result = tmp;
            }
        }

        System.out.println(result + 1);

    }
}
