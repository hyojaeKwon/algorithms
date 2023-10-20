import java.util.Scanner;
public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        
        if ( n == 1 || n == 2) System.out.println(n);
        else {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2 ; i < n ; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
            
            System.out.println(dp[n-1] % 10007);
        }
           
    }
}
