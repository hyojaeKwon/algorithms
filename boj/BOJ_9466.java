import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9466 {
    public static int[] picks;
    public static boolean[] visited, done;
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int students = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            picks = new int[students + 1];
            visited = new boolean[students + 1];
            done = new boolean[students + 1];
            result = 0;

            for(int j = 1; j <= students; j++) {
                picks[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j <= students; j++) {
                if (!done[j]) {
                    solve(j);
                }
            }
            bw.write(students - result + " \n");
        }
        bw.flush();
        bw.close();
    }
    private static void solve(int index) {
        if(done[index]) {
            return;
        }
        if(visited[index]) {
            done[index] = true;
            result += 1;
        }
        visited[index] = true;
        solve(picks[index]);
        done[index] = true;
        visited[index] = false;
    }

}
