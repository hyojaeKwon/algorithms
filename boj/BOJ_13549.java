import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main
{
    public static int maxPos = 100000;
    public static int INF = 100000;
    
    public static int[] isVisited = new int[maxPos + 1];
    public static Queue<Integer> queue = new LinkedList<>();
    
    public static void BFS(int pos){
        Arrays.fill(isVisited, INF);
        isVisited[pos] = 0;
        queue.add(pos);
        
        while(!queue.isEmpty()){
            int cur = queue.remove();
            
            int nextCur1 = cur - 1;
            if( (nextCur1 >= 0 && nextCur1 <= maxPos) && (isVisited[cur] + 1 < isVisited[nextCur1]) ){
                isVisited[nextCur1] = isVisited[cur] + 1;
                queue.add(nextCur1);
            }
            
            int nextCur2 = cur + 1;
            if( (nextCur2 >= 0 && nextCur2 <= maxPos) && (isVisited[cur] + 1 < isVisited[nextCur2]) ){
                isVisited[nextCur2] = isVisited[cur] + 1;
                queue.add(nextCur2);
            }
            
            int nextCur3 = cur * 2;
            if( (nextCur3 >= 0 && nextCur3 <= maxPos) && (isVisited[cur] < isVisited[nextCur3]) ){
                isVisited[nextCur3] = isVisited[cur];
                queue.add(nextCur3);
            }
            
        }
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if( n >= k){
            System.out.print((n - k));
        }
        else{
            BFS(n);
            System.out.print(isVisited[k]);    
        }
        
        
	}
	
}
