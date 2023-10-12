import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main
{

    
    // FACNY
    public static boolean isNumber(String str){
        try{
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
	public static void BOJ_1620(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 시간 초과 해결법 Hash
        HashMap<String, Integer> dictMap = new HashMap<String, Integer>();
        String[] name = new String[n+1];
        
        for (int i = 1 ; i < n + 1 ; i++){
            String nameRead = br.readLine();
            dictMap.put(nameRead, i);
            name[i] = nameRead;
        }
        

        
        for ( int i = 0 ; i < m ; i ++){
            String ask = br.readLine();
            if(isNumber(ask)){
                int index = Integer.parseInt(ask);
                System.out.println(name[index]);
            }
            else{
                System.out.println(dictMap.get(ask));
            }
        }
        
               

	}
}

