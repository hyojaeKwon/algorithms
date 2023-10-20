import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14940
{
    public static int[][] board;
    public static boolean[][] visit;
    public static int n;
    public static int m;

	public static void main(String[] args) throws IOException {
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    board = new int[n][m];
	    visit = new boolean[n][m];

	    int startX = 0;
	    int startY = 0;
	    
	    for(int i = 0 ; i < n ; i ++){
	        StringTokenizer stLine = new StringTokenizer(bf.readLine());
	        for(int j = 0 ; j < m ; j ++){
	            visit[i][j] = false;

	            int k = Integer.parseInt(stLine.nextToken());
	            if(k == 2){
	                board[i][j] = 0;
	                startX = j;
	                startY = i;
	            }
	            else if( k == 1) board[i][j] = -1;
	            else board[i][j] = k;
	        }
	    }
	    
	    
	    bfs(startX,startY);
	    for(int i = 0 ; i < n ; i ++){
	        for(int j = 0 ; j < m ; j++){
	            System.out.print(board[i][j]+ " ");
	        }
	        System.out.println("");
	    }
	    
	    
	}
	
	public static void bfs(int x, int y){
	    int[] xDis = {1,-1,0,0};
	    int[] yDis = {0,0,1,-1};
	    
	    Queue<Integer> bfsQx = new LinkedList<>();
	    Queue<Integer> bfsQy = new LinkedList<>();
	    
	   
	    visit[y][x] = true;
	    bfsQx.add(x);
	    bfsQy.add(y);
	    
	    while(bfsQx.size() != 0){
	       x = bfsQx.poll();
	       y = bfsQy.poll();
	       for(int i = 0 ; i <  4 ; i++){
	        int nx = x + xDis[i];
	        int ny = y + yDis[i];
	        
	        if(0 <= nx && nx < m && 0 <= ny && ny <n && visit[ny][nx] == false){
	            if(board[ny][nx] != 0){
	                visit[ny][nx] = true;
	                board[ny][nx] = board[y][x] + 1;
	                bfsQx.add(nx);
	                bfsQy.add(ny);
	            }
	        }
	    }
	    }
	    
	    
	}
	

}
