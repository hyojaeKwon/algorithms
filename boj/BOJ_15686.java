import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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
    public static int m;
    public static int n; 
    public static int min = Integer.MAX_VALUE;
    public static int[][] distance;
    public static boolean[] select;
    public static int chickenHouseNumber;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	    StringTokenizer stIn = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(stIn.nextToken());
	    m = Integer.parseInt(stIn.nextToken());
	    
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
	    
	    chickenHouseNumber = chicken.size();
	    distance = new int[chicken.size()][home.size() + 1];
	    
	    
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
	    
	    select = new boolean[chickenHouseNumber];
	    for(int i = 0 ; i < select.length ; i++){
	        select[i] = false;
	    }
	    ArrayList<Integer> chickenPick = new ArrayList<Integer>();
	    combination(0,0,chickenPick);
	    System.out.print(min);
	    
	    
	}
	
	public static void calculateMin(ArrayList<Integer> chiArr){
	    
	    int total = 0;
	    
	    for(int i = 0 ; i < distance[0].length - 1 ; i++){
	        Iterator<Integer> it = chiArr.iterator();
	        int tempMin = n * n;
	        while(it.hasNext()){
	            int disValue = it.next().intValue();
	            if(distance[disValue][i] < tempMin){
	                tempMin = distance[disValue][i];
	            }
	        }
	        total += tempMin;
	    }
	    if(min > total){
	        min = total;
	    }
	}
	
	
	public static void combination(int idx, int num, ArrayList<Integer> arr){
	    if(num == m){


	        calculateMin(arr);
	        return;
	    }


	    for(int i = idx ; i < chickenHouseNumber ; i++){
	        if(select[i] == true) continue;
	        select[i] = true;

	        arr.add(i);
	        combination(i ,num + 1, arr);
	        select[i] = false;
	        arr.remove(Integer.valueOf(i));
	    }
	}
	
	
}
