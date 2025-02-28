package programmers;

import java.util.Stack;

public class 큰수만들기 {

    class Solution {
        public String solution(String number, int k) {
            Stack<String> stack = new Stack<>();
            String[] nList = number.split("");
            int times = 0;
            for (int i = 0; i < number.length(); i++) {
                while (!stack.isEmpty() && times < k) {
                    if (Integer.parseInt(stack.peek()) < Integer.parseInt(nList[i])) {
                        stack.pop();
                        times++;
                    } else {
                        break;
                    }
                }
                stack.add(nList[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack.size() - (k - times); i++) {
                sb.append(stack.get(i));
            }
            return sb.toString();
        }
    }
}
