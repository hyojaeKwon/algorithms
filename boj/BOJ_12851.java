import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    static int[][] arr = new int[100001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sTarget = Integer.parseInt(st.nextToken());
        int bTarget = Integer.parseInt(st.nextToken());

        arr[sTarget][1] = 1;
        solve(sTarget);

        bw.write(arr[bTarget][0] + "\n");
        bw.write(arr[bTarget][1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void move(Queue<Integer> queue, int current, int next) {
        if (next < 0 || next >= 100001) {
            return;
        }
        if(arr[next][1] != 0) {
            // new value
            if (arr[current][0] + 1 < arr[next][0]) {
                queue.add(current + 1);
                arr[next][0] = arr[current][0] + 1;
                arr[next][1] = 1;
            } // 중복 value
            else if (arr[current][0] + 1 == arr[next][0]) {
                arr[next][1]++;
                queue.add(next);
            }
        }
        else{
            arr[next][0] = arr[current][0] + 1;
            queue.add(next);
            arr[next][1]++;
        }

    }

    static void solve(int sTarget) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sTarget);

        while(!queue.isEmpty()) {
            Integer polled = queue.poll();
            move(queue, polled, polled + 1);
            move(queue, polled, polled - 1);
            move(queue, polled, polled * 2);
        }

    }
}
