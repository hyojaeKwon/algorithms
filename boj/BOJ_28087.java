import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_28087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long require = Long.parseLong(st.nextToken());
        long maxSum = require * 2;

        int n = Integer.parseInt(st.nextToken());
        Lecture[] lec = new Lecture[n];
        for (int i = 0; i < n; i++) {
            lec[i] = new Lecture(i + 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(lec, (i1, i2) -> Integer.compare(i2.point, i1.point));
        List<Integer> store = new ArrayList<>();

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            int cur = lec[i].point;

            if (sum + cur >= require && sum + cur <= maxSum) {
                store.add(lec[i].idx);
                break;
            }
            if (sum + cur <= require * 2) {
                sum += cur;
                store.add(lec[i].idx);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(store.size()).append("\n");
        for (int i : store) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static class Lecture {
        int point;
        int idx;

        public Lecture(int idx, int point) {
            this.idx = idx;
            this.point = point;
        }
    }
}
