package programmers;

public class 조이스틱 {
    class Solution {
        public int solution(String name) {

            int answer = 0;
            int move = name.length() - 1;

            for (int i = 0; i < name.length(); i++) {
                int j = i + 1;
                while (j < name.length() && name.charAt(j) == 'A') {
                    j++;
                }
                move = Math.min(move, i * 2 + (name.length() - j));
                move = Math.min(move, (name.length() - j) * 2 + i);
                answer += cc(name.charAt(i));
            }
            return answer + move;
        }

        public int cc(char target) {
            int up = (int) target - 'A';
            int down = 'Z' - (int) target + 1;
            return Math.min(up, down);
        }
    }
}
