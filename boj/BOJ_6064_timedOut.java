import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(
		    new InputStreamReader(System.in));

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

	    for(int i = 0 ; i < m ; i++){
	        int tmp = i * n  + x;
	        for(int j = 0 ; j < n ; j++){
	            int tmp2 = j * m + y;
	            if(tmp == tmp2){
	                System.out.println(tmp);
	                return;
	            }
	            if(tmp2 > tmp){
	                break;
	            }
	        }
	    }

	    System.out.println(-1);
	}
}
