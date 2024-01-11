import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    막상 알고리즘은 전혀 어렵지 않았지만
    부르트포스로 문제에 접근하기가 생소했다.
    이렇게 풀어도 되는 것인지 의문이 오지게 들음.
    쓸데없는 생각 하다가 시간을 많이 쓴 듯
*/

public class BOJ_1107
{
    
    static int number;
    static int brokenNum = 0;
    static int min = Integer.MAX_VALUE;
    static boolean[] numberList = {true, true, true, true, true, true, true, true, true, true};
    
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        StringTokenizer stNumber = new StringTokenizer(
            br.readLine());
            
        number = Integer.parseInt(stNumber.nextToken());
        
        min = Math.min(min, Math.abs(100 - number));
        
        StringTokenizer stBroken = new StringTokenizer(br.readLine());
        brokenNum = Integer.parseInt(stBroken.nextToken());
        
                if(brokenNum != 0){
            StringTokenizer stBrokenNumList =
                new StringTokenizer(br.readLine());
            
            for(int i = 0 ; i < brokenNum ; i++){
                int brokenNumber = Integer.parseInt(stBrokenNumList.nextToken());
                numberList[brokenNumber] = false;
            }
        }

        // bfs 돌리는 코드 들어갈 부분
        bfs("");
        System.out.println(min);
	}
	
    static public void bfs(String pick){
	    for( int i = 0 ; i < 10 ; i++) {
	        if(numberList[i] == true){
	            String tmpPick = pick + Integer.toString(i);
	            min = Math.min(min,Math.abs(number - Integer.parseInt(tmpPick)) + tmpPick.length());
	            
	            if(tmpPick.length() < 6) {bfs(tmpPick);}
	        }
	    }
	}
}
