import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9328 {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int times = Integer.parseInt(br.readLine());
            for (int i = 0; i < times; i++) {
                trial(br);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void trial(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[m][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[j][i] = input[j].charAt(0);
            }
        }
        Set<Character> keySet = new HashSet<>();
        String[] keyInput = br.readLine().split("");
        for (String key : keyInput) {
            keySet.add(key.charAt(0));
        }
        System.out.println((solve(map, n, m, keySet)));
    }

    private static int solve(char[][] map, int n, int m, Set<Character> keySet) {
        int ans = 0;

        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        Map<Character, List<int[]>> keyMap = new HashMap<>();

        findEntrance(map, n, m, queue, visit);
        ans = bfs(map, n, m, keySet, queue, keyMap, ans, visit);
        return ans;
    }

    private static int bfs(char[][] map, int n, int m, Set<Character> keySet, Queue<int[]> queue, Map<Character, List<int[]>> keyMap, int ans, boolean[][] visit) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            char now = map[current[0]][current[1]];

            if (now >= 'a' && now <= 'z') {
                keySet.add(now);
                char door = Character.toUpperCase(now);
                if (keyMap.containsKey(door)) {
                    queue.addAll(keyMap.get(door));
                }
            }
            if (now >= 'A' && now <= 'Z' && !keySet.contains(Character.toLowerCase(now))) {
                    keyMap.computeIfAbsent(now, i -> new ArrayList<>()).add(new int[]{current[0], current[1]});
                    continue;
                }

            if (now == '$') {
                ans++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n && map[nx][ny] != '*' && !visit[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }

            }
        }
        return ans;
    }

    private static void findEntrance(char[][] map, int n, int m, Queue<int[]> queue, boolean[][] visit) {
        for (int i = 0; i < m; i++) {
            if (map[i][0] != '*') {
                queue.add(new int[]{i, 0});
                visit[i][0] = true;
            }
            if (map[i][n - 1] != '*') {
                queue.add(new int[]{i, n - 1});
                visit[i][n - 1] = true;
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (map[0][j] != '*') {
                queue.add(new int[]{0, j});
                visit[0][j] = true;
            }
            if (map[m - 1][j] != '*') {
                queue.add(new int[]{m - 1, j});
                visit[m - 1][j] = true;
            }
        }
    }
}
