package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15663 {

    public static int n,m;
    public static int[] num;
    public static ArrayList<Integer> numList = new ArrayList<>();
    public static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        visit = new boolean[n];

        StringTokenizer stNum = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            num[i]= Integer.parseInt(stNum.nextToken());
        }

        Arrays.sort(num);
        Arrays.fill(visit, false);

        dfs(0);

    }


    public static void dfs(int counter){
        // 수 출력
        if(counter == m){
            for(Integer in : numList){
                System.out.print(in + " ");
            }
            System.out.println();
            return;
        }

        // 중복 제거
        int last = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(last != num[i] && !visit[i]){
                last = num[i];

                numList.add(num[i]);
                visit[i] = true;

                dfs(counter + 1);

                numList.remove(numList.size()-1);
                visit[i]= false;
            }

        }

    }
}
