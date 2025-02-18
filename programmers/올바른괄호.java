package programmers;

import java.util.*;

public class 올바른괄호 {

    class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            for(int i = 0 ; i < s.length() ; i++){
                if (s.charAt(i) == '('){
                    stack.add('(');
                    continue;
                }
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if(stack.peek() == '('){
                        stack.pop();
                        continue;
                    }
                    stack.add(')');
                }

            }

            return stack.isEmpty();
        }
    }
}
