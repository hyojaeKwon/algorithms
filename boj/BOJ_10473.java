import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10473 {
    static double startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Double.parseDouble(st.nextToken());
        startY = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        endX = Double.parseDouble(st.nextToken());
        endY = Double.parseDouble(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        double[][] inputs = new double[n + 2][2];
        inputs[0][0] = startX;
        inputs[0][1] = startY;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = Double.parseDouble(st.nextToken());
            inputs[i][1] = Double.parseDouble(st.nextToken());
        }
        inputs[n + 1][0] = endX;
        inputs[n + 1][1] = endY;

        double[][] times = new double[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            double distance = Math.sqrt(Math.pow(inputs[i][0] - startX, 2) + Math.pow(inputs[i][1] - startY, 2));
            times[0][i] = distance / 5.0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == j) {
                    times[i][j] = Double.MAX_VALUE - 0.01;
                } else {
                    times[i][j] = countTime(inputs[i][0], inputs[i][1], inputs[j][0], inputs[j][1]);
                }
            }
        }

        boolean[] visit = new boolean[n + 2];
        visit[0] = true;
        double[] value = new double[n + 2];
        for (int i = 1; i < n + 2; i++) {
            value[i] = times[0][i];
        }
        value[0] = 0;
        for (int i = 0; i < n + 2; i++) {
            double min = Double.MAX_VALUE;
            int u = -1;

            for (int j = 0; j < n + 2; j++) {
                if (!visit[j] && value[j] < min) {
                    min = value[j];
                    u = j;
                }
            }

            if (u == -1) {
                break;
            }
            visit[u] = true;

            for (int j = 0; j < n + 2; j++) {
                if (times[u][j] != 0 && !visit[j]) {
                    value[j] = Math.min(value[j], min + times[u][j]);
                }
            }
        }
        System.out.println(value[n + 1]);
    }

    static double countTime(double sX, double sY, double eX, double eY) {
        double distance = Math.sqrt(Math.pow(eX - sX, 2) + Math.pow(eY - sY, 2));
        double runTime = distance / 5.0;
        double flyTime = 0;
        if (distance < 50) {
            flyTime = (50 - distance) / 5.0 + 2;
        } else if (distance == 50) {
            flyTime = 2;
        } else {
            flyTime = (distance - 50) / 5.0 + 2;
        }
        return Math.min(flyTime, runTime);
    }
}
