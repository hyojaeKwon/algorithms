import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ_5525
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            
        int point = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        StringTokenizer stm = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stm.nextToken());

        StringTokenizer stString = new StringTokenizer(br.readLine());
        String input = stString.nextToken();

        for( int i = 0 ; i < m ; i++){
            char first = input.charAt(i);
            char tmp;
            tmp = first;
            if(first == 'I' && i + (n*2) < m){
                for(int j = 1 ; j < (n*2+1) ; j++){
                    char tmp2 = input.charAt(j + i);
                    if(tmp == tmp2){
                        break;
                    }
                    tmp = tmp2;
                    if( j == n * 2){
                        point++;
                        break;
                    }
                }
            }
        }
	
	    System.out.print(point);
	    
	}
	
}
