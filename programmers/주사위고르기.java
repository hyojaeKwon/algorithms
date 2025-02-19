package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 주사위고르기 {

    class Solution {
        public int n;
        public int[] answer;
        public int win;
        public int aWinTimes;

        public int[] solution(int[][] dice) {
            n = dice.length;
            answer = new int[n / 2];
            List<Integer> dices = new ArrayList<>();

            dfs(0, dices, dice, 0);
            return answer;
        }

        public void dfs(int depth, List<Integer> dices, int[][] dice, int cur) {
            if (depth == n / 2) {
                aWinTimes = 0;
                calculate(dices, dice);
                if (aWinTimes > win) {
                    win = aWinTimes;
                    for (int i = 0; i < n / 2; i++) {
                        answer[i] = dices.get(i) + 1;
                    }
                }
                return;
            }

            for (int i = cur; i < n; i++) {
                dices.add(i);
                dfs(depth + 1, dices, dice, i + 1);
                dices.removeLast();
            }
        }

        public void calculate(List<Integer> dicesA, int[][] dice) {
            List<Integer> arrA = new ArrayList<>();
            List<Integer> arrB = new ArrayList<>();
            List<Integer> dicesB = new ArrayList<>();

            for (int i = 0; i < dice.length; i++) {
                if (!dicesA.contains(i)) {
                    dicesB.add(i);
                }
            }

            fillTable(arrA, 0, 0, 0, dice, dicesA);
            fillTable(arrB, 0, 0, 0, dice, dicesB);
            Collections.sort(arrA);
            Collections.sort(arrB);

            for (Integer i : arrA) {
                aWinTimes += find(i, arrB);
            }
        }

        public int find(int target, List<Integer> arr) {
            int start = 0;
            int end = arr.size();
            while (start < end) {
                int mid = (start + end) / 2;
                if (arr.get(mid) >= target) {
                    end = mid;
                    continue;
                }
                start = mid + 1;
            }
            return end;
        }

        public void fillTable(List<Integer> arr, int depth, int sum, int now, int[][] dice, List<Integer> dices) {
            if (depth == n / 2) {
                arr.add(sum);
                return;
            }
            for (int i = 0; i < 6; i++) {
                fillTable(arr, depth + 1, sum + dice[dices.get(now)][i], now + 1, dice, dices);
            }

        }
    }
}
