package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {

    public static int n;
    public static boolean[] map;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new boolean[n * n];

    }

    public static void solve(int depth){
    // n개의 queen이 있어야 함!!
        if(depth == n){
            count++;
        }


        // 백트래킹
        // 전의 경우의 수에서 다시 콜

    }

}
