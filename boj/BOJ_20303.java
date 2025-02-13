import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_20303 {

    private static int n, m, k;
    private static int[] bag;
    private static ArrayList<ArrayList<Integer>> friends;
    private static boolean[] visit;
    private static int[] depthTable;
    private static int count;


    public static void main(String[] args) {
        initialize();
        visit = new boolean[n + 1];
        depthTable = new int[n + 1];

        Map<Integer, Long> map = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                count = 1;
                long result = dfs(i);
                map.put(i, result);
            }
        }
        knapsack(map);
    }

    private static void knapsack(Map<Integer, Long> map) {
        long[] dpTable = new long[k];
        List<Integer> mapKeys = map.keySet().stream().toList();
        for (int i = 0; i < k; i++) {
            dpTable[i] = 0;
        }
        for (int i = 1; i <= mapKeys.size(); i++) {
            for (int j = k - 1; j >= 1; j--) {
                if (j - depthTable[mapKeys.get(i - 1)] >= 0) {
                    dpTable[j] = Math.max(dpTable[j], dpTable[j - depthTable[mapKeys.get(i - 1)]] + map.get(mapKeys.get(i - 1)));
                }
            }

        }
        System.out.println(dpTable[k - 1]);
    }

    private static long dfs(int index) {
        long cur = 0;
        for (int i = 0; i < friends.get(index).size(); i++) {
            if (!visit[friends.get(index).get(i)]) {
                visit[friends.get(index).get(i)] = true;
                cur += dfs(friends.get(index).get(i));
                count++;
            }
        }
        depthTable[index] = count;
        return cur + bag[index];

    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            friends = new ArrayList<>();
            friends.add(new ArrayList<>());

            bag = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                bag[i] = Integer.parseInt(st.nextToken());
                friends.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int f1 = Integer.parseInt(st.nextToken());
                int f2 = Integer.parseInt(st.nextToken());
                friends.get(f1).add(f2);
                friends.get(f2).add(f1);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}