import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class BOJ_9019
{
    
    public static String[] com;
    
	public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int que = Integer.parseInt(st.nextToken());
            int ans = Integer.parseInt(st.nextToken());
            com = new String[10001];
            Arrays.fill(com, "");
            sol(que,ans);
            System.out.println(com[ans]);
            
        }
	}

	
	public static void sol(int que, int ans){
	    Queue<Integer> queue = new LinkedList<>();
	    queue.add(que);
        
        boolean [] visited=new boolean[10001];
        visited[que] = true;
        

	    while(!queue.isEmpty()){
	        int n = queue.poll();
	        if(visited[ans] == true) return;
	        
	        int d = (n * 2 >= 10000) ? (n*2)%10000 : n*2;
	        int s = (n == 0) ? 9999 : (n-1);
	        int l = (n%1000)*10 + (n/1000);
	        int r = (n%10)*1000+n/10;
	        
	        if(!visited[d]){
	            visited[d] = true;
	            com[d] = com[n] + 'D';
	            queue.add(d);
	            
	        }
	        if(!visited[s]){
	            visited[s] = true;
	            com[s] = com[n] + 'S';
	            queue.add(s);
	            
	        }
	        if(!visited[l]){
	            visited[l] = true;
	            com[l] = com[n] + 'L';
	            queue.add(l);
	            
	        }
	        if(!visited[r]){
	            visited[r] = true;
	            com[r] = com[n] + 'R';
	            queue.add(r);
	            
	        }
	        
	        
	    }
	    
	}
	
	
}
