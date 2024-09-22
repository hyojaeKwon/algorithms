import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class BOJ_1764
{
	public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        
        String[] findList = new String[m];
        
        for(int i = 0 ; i < n ; i++)
            hash.put(br.readLine(),i);
        
        int count = 0;
        List<String> list = new ArrayList<String>();
        
        for( int i = 0 ; i < m ; i++){
            String find = br.readLine();

            if(hash.get(find) != null){
                list.add(find);
                count++;
            }
        }
        
        Collections.sort(list);
        
        
        System.out.println(list.size());
        for(int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
	}
}
