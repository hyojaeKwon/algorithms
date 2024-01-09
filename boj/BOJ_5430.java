/*
  자랑스러운 오답.
  문자열 뒤집으라니까 진짜 뒤집어서 시간초과 맛있게 먹었다.

  그리고 예외처리를 너무 안해줬다. 코드 개더럽게 썼는데, 리팩터링이 필요한 것 같다. 
*/


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Deque;
// Using deque

public class BOJ_5430
{
    
    static int lengthOfList;
    static boolean isRight;
    
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int times = Integer.parseInt(st.nextToken());
        
        
        for(int i = 0 ; i < times ; i++){
            isRight = true;
            
            // code 받기
            StringTokenizer stCode = new StringTokenizer(bf.readLine());
            String code = stCode.nextToken();
            
            // length 받받기
            StringTokenizer stLength = new StringTokenizer(bf.readLine());
            lengthOfList = Integer.parseInt(stLength.nextToken());
            
            // String 정제
            StringTokenizer stList = new StringTokenizer(bf.readLine());
            String list = stList.nextToken();
            list = list.replaceAll("\\[|\\]","");
            String[] strList = list.split(",");
            
            Deque<String> deque = new ArrayDeque<>();
        
            // deque 만들기
            for(int j = 0 ; j < strList.length ; j++){
                deque.add(strList[j]);
            }

            // 방향 결졍하기
            isRight = true;
        
            for(int j = 0 ; j < code.length() ; j++){
                if(code.charAt(j) == 'R'){
                    if(isRight) isRight = false;
                    else isRight = true;
                }
                else{
                    
                    if(lengthOfList > 0){
                        if(isRight) deque.removeFirst();
                        else deque.removeLast();
                    }
                    else {
                        lengthOfList--;
                        System.out.println("error");
                        break;
                    }
                    lengthOfList--;
                }
            }
            if(lengthOfList >= 0) {
                StringBuilder ans = new StringBuilder();
                
                ans.append('[');
                if(isRight){
                    for(int k = 0 ; k < lengthOfList ; k++){
                        ans.append(deque.removeFirst());
                        if(k != lengthOfList - 1) ans.append(',');
                    }    
                }
                else{
                    for(int k = 0 ; k < lengthOfList ; k++){
                        ans.append(deque.removeLast());
                        if(k != lengthOfList - 1) ans.append(',');
                    }
                }
                
                ans.append(']');
                System.out.println(ans.toString());
            }
        }
	}
}

