import java.io.*;
import java.util.*;

public class BOJ_15652 {

    public static int n, m;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        solve(list, 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(List<Integer> list, int i) {

        if (list.size() == m) {
            list.forEach(val -> sb.append(val).append(" "));
            sb.append("\n");
        } else {
            for (int k = i ; k <= n; k++) {
                list.add(k);
                solve(list, k);
                list.remove(Integer.valueOf(k));
            }
        }
    }
}
