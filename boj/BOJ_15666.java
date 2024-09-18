import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15666 {

    static StringBuilder sb = new StringBuilder();
    static int m;
    static int n;
    static int[] inArr;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {
        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            inArr = new int[n];
            resultArr = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                inArr[i] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(inArr);

            solve(0,0);
            bw.write(sb.toString());
        }
    }

    public static void solve(int depth, int idx)
    {
        if (depth == m) {
            for (Integer i : resultArr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int duplicateNum = 0;
        for(int i = idx ; i < n; i++) {
            if (duplicateNum != inArr[i]) {
                resultArr[depth] = inArr[i];
                duplicateNum = inArr[i];
                solve(depth+1, i);
            }
        }
    }
}
