import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453 {
    private static int[] ab, cd;
    private static int number;

    public static void main(String[] args) {
        initialize();
        Arrays.sort(ab);
        Arrays.sort(cd);

        int lt = 0;
        int rt = number * number - 1;
        long answer = 0;

        answer = getAnswer(lt, rt, answer);
        System.out.println(answer);
    }

    private static long getAnswer(int lt, int rt, long answer) {
        while (lt < number * number && rt >= 0) {
            if (ab[lt] + cd[rt] < 0) {
                lt++;
                continue;
            }
            if (ab[lt] + cd[rt] > 0) {
                rt--;
                continue;
            }
            int left = 1;
            while (lt < number * number - 1 && ab[lt] == ab[lt + 1]) {
                lt++;
                left++;
            }
            int right = 1;
            while (rt > 0 && cd[rt] == cd[rt - 1]) {
                rt--;
                right++;
            }
            answer += ((long) left * right);
            lt++;
        }
        return answer;
    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            number = Integer.parseInt(br.readLine());
            int[][] map = new int[4][number];
            generateMap(br, map);
            generateSumTable(map);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateMap(BufferedReader br, int[][] map) throws IOException {
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void generateSumTable(int[][] map) {
        ab = new int[number * number];
        cd = new int[number * number];

        int idx = 0;
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                ab[idx] = map[0][i] + map[1][j];
                cd[idx++] = map[2][i] + map[3][j];
            }
        }
    }
}
