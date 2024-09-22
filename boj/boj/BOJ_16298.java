import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16298{
    
    public static int n;
    public static int m;
    
    public static int[] ledderSnake = new int[101];
    public static int[] map = new int[101];
    public static boolean[] isVisited = new boolean[101];
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stMain = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stMain.nextToken());
        m = Integer.parseInt(stMain.nextToken());
        
        for(int i = 0 ; i < 101 ; i++){
            map[i] = 0;
            ledderSnake[i] = 0;
            isVisited[i] = false;
        }
        
        for(int i = 0 ; i < (n + m)  ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ledderSnake[a] =b;
        }
        BFS();
    }
    
    public static void BFS(){
  
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;
        map[1] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            int nowState = map[now];

            if(now == 100){
                System.out.println(map[100]);
                return;
            }
            
            
            for(int i = 1 ; i <= 6 ; i++){
                int nx = now + i;
                if(nx > 100) continue;
                if(isVisited[nx] ) continue;
                isVisited[nx] = true;
                
                if(ledderSnake[nx] > 0){
                    if(!isVisited[ledderSnake[nx]]){
                        
                        int nnx = ledderSnake[nx];
                        
                        isVisited[nnx] = true;
                        map[nnx] = nowState + 1;
                        q.add(nnx);    
                    }    
                    
                }
                else{
                    
                    map[nx] = nowState + 1; 
                    q.add(nx);
                }
                
            }
        }
        
    }
}
