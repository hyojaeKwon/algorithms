import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_21736
{
    static char[][] map;
    static boolean[][] visit;
    static int lx, ly;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int human = 0;
    
	public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        visit = new boolean[n][m];
        
        
        for (int i = 0 ; i < n; i ++){
            map[i] = br.readLine().toCharArray();
            for (int j = 0 ; j < m ; j++){
                if(map[i][j] == 'I'){
                    lx = j;
                    ly = i;
                }
            }
        }

        bfs(lx,ly,n,m);
        if (human == 0 ) System.out.println("TT");
        else System.out.println(human);
        
	}
	
	public static void bfs(int x,int y,int n, int m){
	    
	    // set visit true
	    visit[y][x] = true;
	    
	    for( int i = 0 ; i < 4 ; i++){
	        // nx declearation
	        int nx = x + dx[i];
	        // ny declearation
	        int ny = y + dy[i];
	        
	        // array overflow or had visited 
	        // continue
	        if (nx >= m || ny >= n || nx < 0 || ny < 0 || visit[ny][nx]) continue;
	        
	        // wall
	        if (map[ny][nx] == 'X') continue;
	        // addition when encounters human
	        if (map[ny][nx] == 'P') human++;
	        
	        // recursion function
	        bfs(nx,ny,n,m);

	    }
	}
}
