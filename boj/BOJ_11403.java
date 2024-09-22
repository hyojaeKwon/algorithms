import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BOJ_11403
{
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int[][] map = new int[n][n];
	    
	    for(int i = 0 ; i < n ; i++){
	        StringTokenizer stInput = new StringTokenizer(br.readLine());
	        for( int j = 0 ; j < n ; j++){
	            int input = Integer.parseInt(stInput.nextToken());
	            map[i][j] = input;
	        }
	    }
	    
	    for( int k = 0 ; k < n ; k++){
	        // 방문
	        for( int i = 0 ; i < n ; i++){
	            for(int j = 0 ; j < n ; j++){
	                if(map[i][k] == 1 && map[k][j] == 1){
	                    map[i][j] = 1;
	                }
	            }
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for( int i = 0 ; i < n ; i++){
	        for( int j = 0 ; j < n ; j++){
	            sb.append(map[i][j]+ " ");
	        }
	        sb.append("\n");
	    }
	    bw.write(sb.toString());
	    
	    bw.flush();
        bw.close();
        br.close();
	    
	}
	

}
