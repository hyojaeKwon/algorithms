package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1043 {

    public static int n; // 사람의 수
    public static boolean[] truth;




    public static void main(String[] args) throws IOException {

        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stInputLine = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stInputLine.nextToken()); // 사람
        int m = Integer.parseInt(stInputLine.nextToken()); // 파티
        truth = new boolean[n+1];
        Arrays.fill(truth, false);

        stInputLine = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(stInputLine.nextToken());
        for (int i = 0; i < truthCount; i++) {
            truth[Integer.parseInt(stInputLine.nextToken())] = true;
        }
        for (int i = 0; i < m; i++) {
            stInputLine = new StringTokenizer(br.readLine());
            if(countParty(stInputLine)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean countParty(StringTokenizer st) {
        int people = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < people; i++) {
            if (truth[Integer.parseInt(st.nextToken())]) {
                return false;
            }
        }
        return true;
    }
}
