package programmers;

public class 도둑질 {
    class Solution {
        public int solution(int[] money) {
            int[] table = new int[money.length + 1];
            // 첫 집을 무조건 텀
            table[1] = money[0];
            for (int i = 2; i < money.length; i++) {
                table[i] = Math.max(table[i - 2] + money[i - 1], table[i - 1]);
            }
            int ans1 = 0;
            for (int i = 1; i <= money.length; i++) {
                ans1 = Math.max(ans1, table[i]);
            }


            // 두번째 집부터 털고 마지막을 텀
            table = new int[money.length + 1];
            for (int i = 2; i <= money.length; i++) {
                table[i] = Math.max(table[i - 2] + money[i - 1], table[i - 1]);
            }
            int ans2 = 0;
            for (int i = 1; i <= money.length; i++) {
                ans2 = Math.max(ans2, table[i]);
            }

            return Math.max(ans1, ans2);
        }
    }
}
