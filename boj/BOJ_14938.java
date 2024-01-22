import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main
{
    
    public static int[][] graph;
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
            
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        String[] items = br.readLine().split(" ");
        
        // graph 입력받기
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                
                if(i!=j){graph[i][j] = 16;}
                else{graph[i][j] = 0;}
                
            }
        }
        for(int i = 0 ; i < r ; i++){
            StringTokenizer stRead = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stRead.nextToken());
            int to = Integer.parseInt(stRead.nextToken());
            int len = Integer.parseInt(stRead.nextToken());
            graph[from - 1][to - 1] = len;
            graph[to - 1][from - 1] = len;   
        }
            
        
        // FW
        for(int k = 0 ; k < n ; k ++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(graph[i][k] + graph[k][j] < graph[i][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int result = 0;
        
        for(int i = 0 ; i < n ; i++){
            int tmp = 0;
            for( int j = 0 ; j < n ; j++){
                if( graph[i][j] <= m){
                    tmp += Integer.parseInt(items[j]);
                }
            }
            if(result < tmp) {result = tmp;}
        }
        
        System.out.println(result);
	}
}
