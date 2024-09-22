package boj;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class BOJ_15650
{
    public static int m;
    public static int n;

    public static ArrayList<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n =Integer.parseInt(st.nextToken());
        dfs(1);

    }

    public static void dfs(int startsAt){
        if(num.size() == n){
            for(Integer in : num){
                System.out.print(in+" ");
            }
            System.out.println();
            return;
        }
        for(int i = startsAt ; i <= m ; i++){
            if(!num.contains(Integer.valueOf(i))){
                num.add(i);
                dfs(i+1);
                num.remove(num.size()-1);
            }
        }

    }
}

