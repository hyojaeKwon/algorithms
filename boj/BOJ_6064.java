import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ_6064
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stNum = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stNum.nextToken());
        
        for(int i = 0 ; i < n ; i++){
            StringTokenizer getInput = new StringTokenizer(br.readLine());
            calculate(
                Integer.parseInt(getInput.nextToken()),
                Integer.parseInt(getInput.nextToken()),
                Integer.parseInt(getInput.nextToken()),
                Integer.parseInt(getInput.nextToken())
                );
        }
	}
	
	public static void calculate(int n, int m, int x, int y){

	    int minMul = 0 ;
        for(int i = 1 ;; i++){
            if((m * i ) % n  == 0){
                minMul = m * i;
                break;
            }
        }

	    for(int i = x ; i <= minMul ; i += n){
	        if((i - y) % m ==0){
	            System.out.println(i);
	            return;
	        }
	    }

	    System.out.println(-1);
	    
	}
}
