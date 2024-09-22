import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int times = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < times ; i++) {
            st = new StringTokenizer(br.readLine());
            int buildings = Integer.parseInt(st.nextToken());
            int rules = Integer.parseInt(st.nextToken());

            int[] spendTimes = new int[buildings];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < buildings; j++) {
                spendTimes[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] rulesReverse = new ArrayList[buildings];
            ArrayList<Integer>[] rulesList = new ArrayList[buildings];
            for (int j = 0; j < rulesList.length; j++) {
                rulesList[j] = new ArrayList<>();
                rulesReverse[j] = new ArrayList<>();
            }

            for (int j = 0; j < rules; j++) {
                st = new StringTokenizer(br.readLine());
                int prev = Integer.parseInt(st.nextToken()) - 1;
                int next = Integer.parseInt(st.nextToken()) - 1;
                rulesList[prev].add(next);
                rulesReverse[next].add(prev);
            }
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken()) - 1;
            System.out.println(solve(buildings, spendTimes, rulesList, rulesReverse, target));
        }
    }


    public static int solve(
            int buildings, int[] spendTimes, ArrayList<Integer>[] rulesList, ArrayList<Integer>[] rulesReverse, int target
    ) {
        int[] degree = new int[buildings];
        int[][] result = new int[buildings][2];

        Arrays.fill(degree, 0);

        Queue<Integer> q = new LinkedList<>();

        for (ArrayList<Integer> arr : rulesList) {
            arr.forEach((Integer i) -> degree[i]++);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        for (int i = 0; i < buildings; i++) {
            int front = q.poll();
            result[i][0] = front;
            for (Integer j : rulesList[front]){
                if (--degree[j] == 0) {
                    q.add(j);
                }
            }
        }



        for (int i = 0; i < result.length; i++) {
            ArrayList<Integer> from = new ArrayList<>();
            for (Integer value : rulesReverse[result[i][0]]) {
                for (int j = 0; j < result.length; j++) {
                    if (result[j][0] == value) {
                        from.add(result[j][1]);
                    }
                }

            }

            if (!from.isEmpty()){
                Integer max = Collections.max(from);
                result[i][1] = max + spendTimes[result[i][0]];
            } else result[i][1] = spendTimes[result[i][0]];


        }

        int returnValue = 0;
        // dp로 걸리는 시간만 count하면 됩니다.
        for (int[] arr : result) {
            if (arr[0] == target) {
                returnValue = arr[1];
            }
        }
        return returnValue;
    }
}
