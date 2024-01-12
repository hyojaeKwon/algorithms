import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ_14500
{
    static int max = -1;
    static int[][] map;
    static int ga;
    static int se;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    se = Integer.parseInt(st.nextToken());
	    ga = Integer.parseInt(st.nextToken());
	    
	    map = new int[se][ga];
	    
	    for(int i = 0 ; i < se ; i++){
	        StringTokenizer stInput = new StringTokenizer(br.readLine());
	        for(int j = 0 ; j < ga ; j++){
	            int input = Integer.parseInt(stInput.nextToken());
	            map[i][j] = input;
	        }
	    }
	    
	    for(int i = 0 ; i < se ; i++){
	        for(int j = 0 ; j < ga ; j++){
                bfs(i,j,1,0);
	        }
	    }
	    
	    System.out.println(max);
	    
	}
	
	
	// visited 처리해야하는데?
	
	public static void bfs(int inSe, int inGa, int times, int point){
	    int[] dx = {1, -1 , 0, 0};
	    int[] dy = {0, 0, 1, -1};
	    
	    point = point + map[inSe][inGa];
	    times++;
	    
	    if(inSe == 3 && inGa == 0){
	        System.out.println(point);
	    }
	    if(times == 4){
	        
	       // System.out.println(point +" "+ inSe +" "+ inGa);
	        max = Math.max(point, max);
	        return;
	    }
	    
	    
	    
	    for( int i = 0 ; i < 4 ; i++){
	        int nx = inGa + dx[i];
	        int ny = inSe + dy[i];
	        if( 0 <= nx && nx < ga && 0 <= ny && ny < se && times < 4){
	            bfs(ny, nx, times, point);
	        }
	    }
	}
}
