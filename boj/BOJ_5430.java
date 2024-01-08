/*
  자랑스러운 오답.
  문자열 뒤집으라니까 진짜 뒤집어서 시간초과 맛있게 먹었다.
*/


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ_5430
{
    
    static int lengthOfList;
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int times = Integer.parseInt(st.nextToken());
        
        
        for(int i = 0 ; i < times ; i++){
            // code 받기
            StringTokenizer stCode = new StringTokenizer(bf.readLine());
            String code = stCode.nextToken();
            
            // length 받받기
            StringTokenizer stLength = new StringTokenizer(bf.readLine());
            lengthOfList = Integer.parseInt(stLength.nextToken());
            
            // String 정제
            StringTokenizer stList = new StringTokenizer(bf.readLine());
            String list = stList.nextToken();
            list = list.replaceAll("\\[|\\]|,","");


            StringBuffer sb= new StringBuffer(list);
            
            for(int j = 0 ; j < code.length() ; j++){
                if(code.charAt(j) == 'R'){
                    sb = reverseString(sb);
                }
                else{
                    lengthOfList--;
                    if(lengthOfList > 0){
                        sb = removeFirst(sb);
                    }
                    else {
                        System.out.println("error");
                        break;
                    }
                }
            }
            if(lengthOfList > 0) {
                StringBuilder ans = new StringBuilder();
                String ansList = sb.toString();
                ans.append('[');
                for(int k = 0 ; k < ansList.length() ; k++){
                    ans.append(ansList.charAt(k));
                    if(k != ansList.length() - 1) ans.append(',');
                }
                ans.append(']');
                System.out.println(ans.toString());
            }
            
            
        }
        
        
	}
	
	public static StringBuffer reverseString(StringBuffer input){
	    return input.reverse();
	}
	public static StringBuffer removeFirst(StringBuffer input){
	    input.deleteCharAt(0);
	    return input;
	}
}
