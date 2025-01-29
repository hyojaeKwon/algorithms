import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {

    private static int size;
    private static int[] input;
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        input = new int[size];
        map = new boolean[size][size];

        input(br);
        generatePalindromeTable();
        answering(br);
    }

    private static void answering(BufferedReader br) throws IOException {
        int times = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(stringTokenizer.nextToken());
            int i2 = Integer.parseInt(stringTokenizer.nextToken());
            sb.append(map[i1 - 1][i2 - 1] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void generatePalindromeTable() {
        for (int i = 0; i < size; i++) {
            map[i][i] = true;
        }

        for (int i = 0; i + 1 < size; i++) {
            map[i][i + 1] = Math.abs(input[i] - input[i + 1]) == 0;
        }

        for (int diff = 2; diff <= size; diff++) {
            for (int i = 0; i + diff < size; i++) {
                int target = i + diff;
                map[i][target] = map[i + 1][target - 1] && input[i] == input[target];
            }
        }
    }
}
