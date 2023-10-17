import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStreamReader;
public class Main
{
    public static HashSet<Integer> set = new HashSet<Integer>();
    
    public static void removeSetAll(){
        // for(int value : set){
        //     System.out.println(value);
        //     set.remove(value);
        // }
        set.clear();
    }
    public static void add(int i){
        set.add(i);
    }
    
    public static void remove(int i){
        set.remove(i);
    }
    
    public static int check(int i){
        if(set.contains(i)) return 1;
        else return 0;
    }
    
    public static void toggle(int i){
        if(set.contains(i)) set.remove(i);
        else set.add(i);
    }
    
    public static void all(){
        set.clear();
        for(int i = 1 ; i < 21 ; i++){
            set.add(i);
        }
    }
    
    public static void empty(){
        set.clear();
    }
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1;
        
        for(int i = 0 ; i < n ; i++){
            st1 = new StringTokenizer(br.readLine());
            String tag = st1.nextToken();
            
            if( tag.equals("all")) {
                all();
            }
            else if (tag.equals("empty")){
                empty();
            }
            else {
                int tagNumber = Integer.parseInt(st1.nextToken());
            
                if( tag.equals("add")){
                    add(tagNumber);    
                }
                else if( tag.equals("remove")) {
                remove(tagNumber);
                }
                else if( tag.equals("check")) {
                    System.out.println(check(tagNumber));
                }
                else  {
                    toggle(tagNumber);
                }    
            }
            
            
            
        }
	}
}
