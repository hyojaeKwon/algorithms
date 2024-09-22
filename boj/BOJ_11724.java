import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_11724
{
    public static boolean[] flag;
    public static boolean[][] node;
    public static int n;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    flag = new boolean[n+1];
	    node = new boolean[n+1][n+1];
	    
	    for(int i = 0 ; i < m ; i++){
	        StringTokenizer flagST = new StringTokenizer(bf.readLine());
	        
	        int s1 = Integer.parseInt(flagST.nextToken());
	        int s2 = Integer.parseInt(flagST.nextToken());
	        
	        node[s1][s2] = true;
	        node[s2][s1] = true;
	        
	    }
	    
	    
	    int count = 0;
	    
	    for(int i = 1 ; i <= n ; i++){
	        if(flag[i] == false){
	            DFS(i);
	            count++;
	        }
	    }
	    
	    System.out.println(count);
	    
	}
	
	public static void DFS(int start){
	    //종료조건
	    if(flag[start] == true){
	        return;
	    }
	    
	    flag[start] = true;
	    for(int i = 1 ; i <= n ; i++ ){
	        if(node[start][i] == true){
	            DFS(i);
	        }
	    }
	}
}
