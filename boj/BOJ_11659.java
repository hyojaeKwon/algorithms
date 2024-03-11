import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_11659
{
    
	public static void main(String[] args) throws IOException {
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] sumArr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		sumArr[0] = Integer.parseInt(st.nextToken());
		
		for(int i = 1 ; i < n ; i ++){
		    sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
		}

		
		for(int i = 0 ; i < m ; i++){
		    st = new StringTokenizer(br.readLine());
		    int fn = Integer.parseInt(st.nextToken());
		    int sn = Integer.parseInt(st.nextToken());
		    try{
		        System.out.println(sumArr[sn-1] - sumArr[fn-2]);    
		    }
		    catch(Exception e){
		        System.out.println(sumArr[sn-1]);
		    }
		    
        }
	}
}
