import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1003
{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int dp[][] = new int[2][41];
		
		dp[0][0] = 1;
		dp[1][0] = 0;
		
		dp[0][1] = 0;
		dp[1][1] = 1;
		
		for(int i = 2 ; i < 41 ; i ++){
		    dp[0][i] = dp[0][i-1] + dp[0][i-2];
		    dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}
		
		for(int i = 0 ; i < n ; i++){
		    StringTokenizer stRead = new StringTokenizer(bf.readLine());
		    int thisI = Integer.parseInt(stRead.nextToken());
		    System.out.println(dp[0][thisI] + " " + dp[1][thisI]);
		}
		

	}
}
