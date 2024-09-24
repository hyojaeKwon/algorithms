import java.io.*;

public class BOJ_2239 {
    static int[][] input = new int[9][9];
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
                ) {
            for (int i = 0; i < 9; i++) {
                String st = br.readLine();
                for(int j = 0; j < 9; j++) {
                    input[i][j] = Integer.parseInt(String.valueOf(st.charAt(j)));
                }
            }
            solve(0);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(input[i][j]);
                }
                sb.append("\n");
            }
            bw.write(sb.toString());

        }
    }

    private static void solve(int target) {
        if (target == 81) {
            flag = true;
            return;
        }
        int row = target / 9;
        int col = target % 9;
        if (input[row][col] != 0) {
            solve(++target);
        } else {
            for(int i = 1; i < 10; i++) {
                if (isValid(row, col, i)) {
                    input[row][col] = i;
                    solve(target + 1);
                    if (flag) {
                        return;
                    }
                    input[row][col] = 0;
                }
            }
        }
    }
    private static boolean isValid(int row, int col, int target) {
        for(int i = 0; i < 9; i++) {
            if(input[row][i] == target || input[i][col] == target) {
                return false;
            }
        }
        int sRow = row / 3 * 3;
        int sCol = col / 3 * 3;
        for(int r = sRow; r < sRow + 3; r++) {
            for(int c = sCol; c < sCol + 3; c++) {
                if(input[r][c] == target) {
                    return false;
                }
            }
        }
        return true;
    }
}
