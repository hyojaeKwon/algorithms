import java.io.*;

public class BOJ_2448 {

    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[2 * n - 1][n];

        solve(n, n - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <  n; i++) {
            for(int j = 0; j < 2 * n - 1; j++) {

                if(map[j][i]) {
                    sb.append("*");
                }else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int n, int x, int y) {
        if (n == 3) {
            map[x][y] = true;
            map[x + 1][y + 1] = true;
            map[x - 1][y + 1] = true;
            map[x - 2][y + 2] = true;
            map[x - 1][y + 2] = true;
            map[x][y + 2] = true;
            map[x + 1][y + 2] = true;
            map[x + 2][y + 2] = true;
        }
        else {
            solve(n/2, x, y);
            solve(n/2, x + n / 2, y + n / 2);
            solve(n/2, x - n / 2, y + n / 2);
        }
    }
}
