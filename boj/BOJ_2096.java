import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 코드 열심히 더러움 */

public class Main
{
    public static int[][][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(
		    new InputStreamReader(System.in));
		    
		int n = Integer.parseInt(bf.readLine());
	    if(n == 0){return;}
	    graph = new int[3][n][3];
	    
	    for(int i = 0 ; i < n ; i++){
	        StringTokenizer st = new StringTokenizer(bf.readLine());
	        graph[0][i][0] = Integer.parseInt(st.nextToken());
	        graph[0][i][1] = Integer.parseInt(st.nextToken());
	        graph[0][i][2] = Integer.parseInt(st.nextToken());
	    }
	    
	    // max
	    for(int i = 0 ; i < n ; i ++){
	        for(int j = 0 ; j < 3 ; j ++){
	            int tmp = 0;
	            if( (i - 1) >= 0){
	                for(int k = -1 ; k < 2 ; k++){
	                    if(j + k >= 0 && j + k < 3){
	                        if(graph[1][i - 1][j + k] > tmp){
	                            tmp = graph[1][i - 1][j + k];
	                        }
	                    }
	                }
	            }
	            graph[1][i][j] = graph[0][i][j] + tmp;
	        }
	    }
	    
	    // min
	    for(int i = 0 ; i < n ; i ++){
	        for(int j = 0 ; j < 3 ; j ++){
	            int tmp = 10*100000;
	            if( (i - 1) >= 0){
	                for(int k = -1 ; k < 2 ; k++){
	                    if(j + k >= 0 && j + k <= 2){
	                        if(graph[2][i - 1][j + k] < tmp){
	                            tmp = graph[2][i - 1][j + k];
	                        }
	                    }
	                }
	                
	                if(tmp == 10*100000) tmp = 0;
	                graph[2][i][j] = graph[0][i][j] + tmp;
	            }
	            else {
	              graph[2][i][j] = graph[0][i][j];  
	            }
	        }
	    }
	    

	    int max = 0;
	    int min = Integer.MAX_VALUE;
	    for(int i = 0 ; i < 3; i++){
	        if(graph[1][n-1][i] > max){
	            max =graph[1][n-1][i];
	        }
	        if(graph[2][n-1][i] < min){
	            min = graph[2][n-1][i];
	        }
	    }
	    System.out.print(max + " " + min);
	    
	    
	}
}
