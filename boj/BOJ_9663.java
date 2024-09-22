package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {

    public static int n;
    public static int[] map;
    public static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n];

        solve(0);
        System.out.println(count);

    }

    public static boolean attack(int depth){
        for(int i = 0 ; i < depth ; i++){
            if(map[i] == map[depth] || Math.abs(i - depth) == Math.abs(map[i] - map[depth])){
                return true;
            }
        }
        return false;
    }

    public static void solve(int depth){
    // n개의 queen이 있어야 함!! -> 한 행에 하나씩 있어야함
        if(depth == n){
            count++;
            return;
        }

        for (int i = 0 ; i < n ; i++){
            map[depth] = i;
            if(!attack(depth)){
                solve(depth+1);
            }
        }


    }

}
