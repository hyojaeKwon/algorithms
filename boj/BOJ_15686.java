import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_15686
{
    public static class Point{
        public int x;
        public int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    StringTokenizer stIn = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(stIn.nextToken());
	    int m = Integer.parseInt(stIn.nextToken());
	    
	    ArrayList<Point> home = new ArrayList<Point>();
	    ArrayList<Point> chicken = new ArrayList<Point>();
	    
        for(int i = 0 ; i < n ; i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int j = 0 ; j < n; j++){
	            int now = Integer.parseInt(st.nextToken());
	            if(now == 1){
	                home.add(new Point(i,j));
	            }
	            else if(now == 2){
	                chicken.add(new Point(i,j));
	            }
	        }
	        
	    }
	    int[][] distance = new int[chicken.size()][home.size() + 1];
	    for(int i = 0 ; i < chicken.size() ; i++){
	        Point chickenPoint = chicken.get(i);
	        int disTotal = 0; 
	        for( int j = 0 ; j < home.size() ; j++){
	            Point homePoint = home.get(j);
	            int dis = Math.abs(chickenPoint.x - homePoint.x) + Math.abs(chickenPoint.y - homePoint.y);
	            distance[i][j] = dis;
	            disTotal += dis;
	            }
	            distance[i][home.size()] = disTotal;
	        
	    }
	    
	    Arrays.sort(distance, (o1 , o2) -> {
	       return o1[home.size()] - o2[home.size()]; 
	    });
	    for(int i = 0 ; i < chicken.size() ; i++){
	        
	        for( int j = 0 ; j < home.size() + 1 ; j++){
	             System.out.print(distance[i][j] + " ");
	            }
                System.out.println();
	    }
	    
	   
	    int total = 0;
	    for( int i = 0 ; i < home.size() ; i++){
	        int min = n * n;
	        for(int j = 0 ; j < m ; j++){
	            int dis = distance[j][i];
	            if(dis < min){
	                min = dis;
	            }
	        }
	        total += min;
	    }
	    System.out.println(total);
	    
	}
	
	
}
