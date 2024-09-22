import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095
{
	public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] timesList = new int[11];
        timesList[0] = 0;
        timesList[1] = 1;
        timesList[2] = 2;
        timesList[3] = 4;
        
        for(int i = 4 ; i < 11 ; i++){
            timesList[i] = timesList[i-1]+timesList[i-2]+  timesList[i-3];
        }

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            int tmp = Integer.parseInt(br.readLine());
            System.out.println(timesList[tmp]);
        }        
      
	}
}
