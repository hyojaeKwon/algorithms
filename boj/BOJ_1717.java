import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int code = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (code == 0) union(a, b);
            else sb.append(isSameParent(a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static String isSameParent(int a, int b) {
        if(find(a) == find(b)) {
            return "YES";
        }
        return "NO";
    }
    private static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) {
            return;
        }
        if (a > b) {
            parent[parentA] = parentB;
        }
        else {
            parent[parentB] = parentA;
        }

    }
    private static int find(int a) {
        if(a == parent[a]){
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

}
