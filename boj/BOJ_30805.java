import java.io.*;
import java.util.*;

public class BOJ_30805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int s1 = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> q1 = new LinkedList<>();
        List<Integer> q2 = new LinkedList<>();
        for(int i = 0; i < s1; i++) {
            q1.add(Integer.parseInt(st.nextToken()));
        }
        int s2 = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < s2; i++) {
            q2.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> res = new LinkedList<>();
        List<Integer> result = solve(q1, q2, res);
        bw.write(result.size() + "\n");
        if(!result.isEmpty()){
            result.forEach(i -> {
                try {
                    bw.write(i + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> solve(List<Integer> q1, List<Integer> q2, List<Integer> res) {
        if(q1.isEmpty() || q2.isEmpty()) {
            return res;
        }

        int q1Max = q1.stream().max(Integer::compareTo).get();
        int q2Max = q2.stream().max(Integer::compareTo).get();
        int q1Idx = q1.indexOf(q1Max);
        int q2Idx = q2.indexOf(q2Max);

        if(q1Max == q2Max) {
            res.add(q1Max);
            return solve(q1.subList(q1Idx+1, q1.size()), q2.subList(q2Idx+1, q2.size()), res);
        } else if (q1Max > q2Max) {
            q1.remove(q1Idx);
            return solve(q1, q2, res);
        } else {
            q2.remove(q2Idx);
            return solve(q1, q2, res);
        }


    }
}
