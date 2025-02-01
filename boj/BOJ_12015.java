import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015 {

    private static int input;
    private static int[] arr;
    private static int[] targetArr;


    public static void main(String[] args) {
        initialize();
        solve();
    }

    private static void solve() {
        targetArr = new int[input];
        int currentIndex = 0;
        targetArr[currentIndex] = arr[0];

        for (int i = 1; i < input; i++) {
            int currentTarget = arr[i];

            if (targetArr[currentIndex] < currentTarget) {
                targetArr[++currentIndex] = currentTarget;
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
        }

        System.out.println(currentIndex + 1);
    }

    private static void initialize() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(br.readLine());
            arr = new int[input];
            initializeArray(br);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void initializeArray(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
