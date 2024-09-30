import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16724 {
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] hopIn;

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        hopIn = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = input[j].charAt(0);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }
    static void dfs(int i, int j) {
        char dir = map[i][j];
        visited[i][j] = true;
        int nextI = i;
        int nextJ = j;

        if(dir == 'L') {
            nextJ = j - 1;
        }else if(dir == 'R') {
            nextJ = j + 1;
        }else if(dir == 'U') {
            nextI = i - 1;
        }else{
            nextI = i + 1;
        }

        if(!visited[nextI][nextJ]){
            dfs(nextI, nextJ);
        }else {
            if(!hopIn[nextI][nextJ]) answer++;
        }
        hopIn[i][j] = true;
    }
}
