import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24955 {

    private static final long DIVIDE = 1_000_000_007;
    private static int n;
    private static int[] home;
    private static List<Integer>[] map;

    public static void main(String[] args) throws IOException {
        int times;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        times = Integer.parseInt(st.nextToken());
        home = new int[n + 1];
        map = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            home[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(solve(from, to) % DIVIDE).append("\n");
        }
        System.out.println(sb);
    }

    private static long solve(int from, int to) {
        boolean[] visit = new boolean[n + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(from, home[from]));
        visit[from] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.current == to) {
                return point.value;
            }

            for (int i : map[point.current]) {
                if (!visit[i]) {
                    visit[i] = true;
                    long result = (((point.value % DIVIDE) * (power(String.valueOf(home[i]).length()) % DIVIDE)) % DIVIDE + home[i] % DIVIDE) % DIVIDE;
                    queue.add(new Point(i, result));
                }
            }
        }
        return 0;
    }

    private static long power(int count) {
        return Long.parseLong("1" + "0".repeat(Math.max(0, count)));
    }

    static class Point {
        int current;
        long value;

        public Point(int current, long value) {
            this.current = current;
            this.value = value;
        }
    }
}
