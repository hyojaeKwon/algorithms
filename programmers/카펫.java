package programmers;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] ans = new int[2];

            for (int i = 3; i <= (brown - 2) / 2; i++) {
                int j = (brown - (i - 2) * 2) / 2;

                if ((i - 2) * (j - 2) == yellow) {
                    if (i < j) {
                        int tmp = i;
                        i = j;
                        j = tmp;
                    }
                    ans[0] = i;
                    ans[1] = j;
                }

            }
            return ans;
        }
    }
}
