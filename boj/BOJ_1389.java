package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.Arrays;

public class BOJ_1389
{
    // # of users
    public static int n;
    
    // # of relationships
    public static int m;
    
    // relationship table
    public static boolean[][] table;
    public static boolean[] isVisited;
    public static int[] resultTable;
    
	public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        resultTable = new int[n + 1];
        table = new boolean[n + 1][n + 1];
        isVisited = new boolean[n + 1];
        int[] result = new int[n + 1];
        
        for(int i = 0 ; i <= n ; i++ ){
            for(int j = 0 ; j <=n ; j++){
                table[i][j] = false;
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            StringTokenizer stRead = new StringTokenizer(bf.readLine());
            
            int f1 = Integer.parseInt(stRead.nextToken());
            int f2 = Integer.parseInt(stRead.nextToken());
            
            table[f1][f2] = true;
            table[f2][f1] = true;
            
        }
        
        for(int i = 1 ; i <= n ; i ++){
            
            int status = BFS(i);
            
            result[i] = status;
        }


        
        int minIdx = 1;
        for(int i = 1 ; i <= n ; i++){
            if(result[i] < result[minIdx]){
                minIdx = i;
            }
        }
        System.out.println(minIdx);
        
	}
	
	public static int BFS(int startPoint){
	    for(int i = 0 ; i <= n ; i++) {
	        resultTable[i] = 0;
	        isVisited[i] = false;
	        
	    }
	    Queue<Integer> q = new LinkedList<>();
	    isVisited[startPoint] = true;
	    q.add(startPoint);
	    
	    while(!q.isEmpty()){
	        int now = q.poll();
	        for(int i = 1 ; i <= n ; i++){
	            if(table[now][i] == true && isVisited[i] == false ){
	                resultTable[i] = resultTable[now] + 1;
	                isVisited[i] = true;
	                q.add(i);
	            }
	        }
	    }
	    
        	    
	   
	    return Arrays.stream(resultTable).sum();
	}
	
	
}
