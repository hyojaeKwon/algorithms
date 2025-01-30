import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {

    private static int size;
    private static int[] numbers;
    private static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        numbers = new int[size];
        isPalindrome = new boolean[size][size];

        readInput(br);
        preprocessPalindromeTable();
        processQueries(br);
    }

    private static void readInput(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void preprocessPalindromeTable() {
        // 길이가 1인 경우(자기 자신) -> 항상 팰린드롬
        for (int i = 0; i < size; i++) {
            isPalindrome[i][i] = true;
        }

        // 길이가 2인 경우 -> 두 수가 같으면 팰린드롬
        for (int i = 0; i < size - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }

        // 길이가 3 이상인 경우
        for (int length = 3; length <= size; length++) {
            for (int start = 0; start <= size - length; start++) {
                int end = start + length - 1;
                if (numbers[start] == numbers[end] && isPalindrome[start + 1][end - 1]) {
                    isPalindrome[start][end] = true;
                }
            }
        }
    }

    private static void processQueries(BufferedReader br) throws IOException {
        int queryCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (queryCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            sb.append(isPalindrome[start][end] ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }
}