import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n];
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {

            // stack 비교하며 빼는 과정
            while(!stack.isEmpty() && input[stack.peek()] < input[i]) {
                ans[stack.pop()] = input[i];
            }
            stack.add(i);
        }
        // 맨 뒤에 -1로 채우기
        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
