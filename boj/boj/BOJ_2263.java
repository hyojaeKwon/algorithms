import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2263 {
    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static int[] inOrderIdx;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            n = Integer.parseInt(br.readLine());
            inOrder = new int[n + 1];
            postOrder = new int[n + 1];
            inOrderIdx = new int[n + 1];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) {
                inOrder[i] = Integer.parseInt(st1.nextToken());
                postOrder[i] = Integer.parseInt(st2.nextToken());
            }
            for(int i = 1; i <= n; i++) {
                inOrderIdx[inOrder[i]] = i;
            }

            solve(1, n, 1, n);
            bw.write(sb.toString());
        }
    }


    static void solve(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return;
        }

        int root = postOrder[pe];
        int rootIdx = inOrderIdx[root];
        sb.append(root).append(" ");

        int leftLen = rootIdx - is;

        solve(is, rootIdx - 1, ps, ps + leftLen - 1);
        solve(rootIdx+1,ie, ps+ leftLen, pe - 1);
    }
}
