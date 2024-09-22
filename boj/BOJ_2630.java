import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2630
{
    public static int[][] table;
    
    public static int blue = 0;
    public static int white = 0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
	    table = new int[n][n];
	    
	    StringTokenizer st;
	    
	    for(int i = 0 ; i < n ; i++){
	        st = new StringTokenizer(bf.readLine(), " ");
	        for ( int j = 0 ; j < n ; j ++){
	            table[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    cutting(n, n - 1 , n - 1);
	    System.out.println(white);
	    System.out.println(blue);
	}
	
	public static boolean checkIsHybrid(int width, int posx, int posy){
	    int state = table[posy][posx];

	    for ( int i = posy - width + 1 ; i < posy + 1 ; i ++){
	        for ( int j = posx - width + 1;  j < posx + 1 ; j ++){
	            if(state != table[i][j]) return true;
	        }
	    }
	    
	    return false;
	}
	
	public static void cutting(int width, int posx, int posy){
	    if(width == 1){
	        if (table[posy][posx] == 1) blue ++;
	        else white++;
	        return;
	    }
	    // 전체 색종이 확인
	    if(!checkIsHybrid(width, posx, posy)){
	        if(table[posy][posx] == 1) blue ++;
	        else white++;
	        return;
	    }
	    
	    // 색종이 분할
	    int newposx;
	    int newposy;
	    	    
	    int cutWidth = width / 2;
	    // 색종이 체크
	    // step 1 - 4
	    if(checkIsHybrid(cutWidth, posx, posy)){
	        cutting(cutWidth,posx,posy);
	    } else {
	        if(table[posy][posx] == 1) blue ++;
	        else white++;
	    }
	    
	    // step 2 - 3
	    newposx = posx - cutWidth;

	    if(checkIsHybrid(cutWidth, newposx, posy)){
	        cutting(cutWidth,newposx,posy);
	    } else {
	        if(table[posy][newposx] == 1) blue ++;
	        else white++;
	    }
	    
	    // step 3 - 2
	    newposx = posx - cutWidth;

	    newposy = posy - cutWidth;
	    
	    if(checkIsHybrid(cutWidth, newposx, newposy)){
	        cutting(cutWidth,newposx,newposy);
	    } else {
	        if(table[newposy][newposx] == 1) blue ++;
	        else white++;
	    }
	    
	    // step 4 - 1
	    newposy = posy - cutWidth;
	    if(checkIsHybrid(cutWidth, posx, newposy)){
	        cutting(cutWidth,posx,newposy);
	    } else {
	        if(table[newposy][posx] == 1) blue ++;
	        else white++;
	    }
	    
	 
	    
	}
	
}
