import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Objects;

public class BOJ_10026
{
    public static char[][] map;
    public static boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    public static int n;
    public static int count = 0;
    public static int generalCount = 0;
    
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		map = new char[n][n];
		
		visit = new boolean[n][n];
		
		for(int i = 0 ; i < n ; i++){
		    String str = bf.readLine();
		    for ( int j = 0 ; j < n ; j++){
		        map[i][j] = str.charAt(j);
		        visit[i][j] = false;
		    }
		    
		}
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    BFS(j, i);
                    generalCount++;
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
		    for ( int j = 0 ; j < n ; j++){
		        visit[i][j] = false;
		        if (map[i][j] == 'G') map[i][j] = 'R';
		    }
		    
		}


		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    BFS(j, i);
                    count++;
                }
            }
        }
        
        
        

		System.out.print(generalCount + " ");
		System.out.print(count);
		

	}
	
	public static void BFS(int x, int y){
	    Queue<Point> queue = new LinkedList<Point>();
	    visit[y][x] = true;
	    queue.add(new Point(x,y));
	    while(!queue.isEmpty()){
	        Point point = queue.poll();
	        for(int i = 0 ; i < 4 ; i++){
	            int nx = point.x + dx[i];
	            int ny = point.y + dy[i];
	            if(0 <= nx && nx < n && 0 <= ny && ny < n && visit[ny][nx] == false){
	               if(Objects.equals(map[point.y][point.x],map[ny][nx])){
	                    queue.add(new Point(nx,ny));
	                    visit[ny][nx] = true;
	                   
	               }
	            }
	        }
	    }
	    
	}
	
	static class Point {
	    int x;
	    int y;
	    
	    public Point(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	} 
}
