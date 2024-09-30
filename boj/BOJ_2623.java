import java.io.*;
import java.util.*;

public class BOJ_2623 {
    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] input = br.readLine().split(" ");

         int n = Integer.parseInt(input[0]);
         int k = Integer.parseInt(input[1]);

         int[] inDegree = new int[n + 1];
         ArrayList<Integer>[] map = new ArrayList[n + 1];
         for(int i = 1; i <= n; i++) {
             map[i] = new ArrayList<>();
         }

         for(int i = 1; i <= k; i++) {
             input = br.readLine().split(" ");
             int time = Integer.parseInt(input[0]);
             for(int j = 1; j < time; j++) {
                 int u = Integer.parseInt(input[j]);
                 int v = Integer.parseInt(input[j + 1]);
                 map[u].add(v);
                 inDegree[v]++;
             }
         }

         Queue<Integer> queue = new LinkedList<>();
         ArrayList<Integer> ans = new ArrayList<>();
         for(int i = 1; i <= n; i++) {
             if(inDegree[i] == 0) {
                 queue.add(i);
             }
         }

         while(!queue.isEmpty()) {
             int top = queue.poll();
             ans.add(top);
             for( Integer i : map[top]) {
                 if(--inDegree[i] == 0) {
                     queue.add(i);
                 }
             }
         }

         StringBuilder sb = new StringBuilder();
         if (ans.size() == n) {
            for (Integer a : ans) {
                sb.append(a).append("\n");
            }
         }else {
            sb.append(0).append("\n");
         }
         System.out.println(sb);
    }
}
