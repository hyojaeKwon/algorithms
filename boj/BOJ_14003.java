import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14003 {

    private static int input;
    private static int[][] arr;
    private static int[] targetArr;


    public static void main(String[] args) {
        initialize();
        solve();
    }

    private static void solve() {
        targetArr = new int[input];
        int currentIndex = 0;
        targetArr[currentIndex] = arr[0][0];
        arr[0][1] = 0;
        for (int i = 1; i < input; i++) {
            int currentTarget = arr[i][0];

            if (targetArr[currentIndex] < currentTarget) {
                targetArr[++currentIndex] = currentTarget;
                arr[i][1] = currentIndex;
                continue;
            }

            int first = 0;
            int last = currentIndex;

            while (first < last) {
                int mid = (first + last) / 2;
                if (targetArr[mid] < currentTarget) {
                    first = mid + 1;
                    continue;
                }
                last = mid;
            }
            targetArr[first] = currentTarget;
            arr[i][1] = first;
        }
        findLIS(currentIndex);
    }

    private static void findLIS(int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(idx + 1).append("\n");

        int[] lis = new int[idx + 1];
        for (int i = input - 1; i >= 0; i--) {
            if (arr[i][1] == idx) {
                lis[idx--] = arr[i][0];
            }
        }
        for (int li : lis) {
            sb.append(li).append(" ");
        }
        System.out.println(sb);
    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(br.readLine());
            arr = new int[input][2];
            initializeArray(br);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void initializeArray(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
    }
}
