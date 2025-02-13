import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2143 {

    private static long[] sumA;
    private static long[] sumB;


    public static void main(String[] args) {
        int target;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            target = Integer.parseInt(br.readLine());
            initializeA(br);
            initializeB(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<Long, Long> sumMap = new HashMap<>();
        for (int i = 1; i < sumA.length; i++) {
            for (int j = i; j < sumA.length; j++) {
                long tmp = sumA[j] - sumA[i - 1];
                if (sumMap.containsKey(tmp)) {
                    sumMap.put(tmp, sumMap.get(tmp) + 1);
                    continue;
                }
                sumMap.put(tmp, 1L);
            }
        }

        long result = 0;
        for (int i = 1; i < sumB.length; i++) {
            for (int j = i; j < sumB.length; j++) {
                long tmp = sumB[j] - sumB[i - 1];
                if (sumMap.containsKey(target - tmp)) {
                    result += sumMap.get(target-tmp);
                }
            }
        }

        System.out.println(result);
    }

    private static void initializeA(BufferedReader br) throws IOException {
        int aLength = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long tmpSum = 0;
        sumA = new long[aLength + 1];
        sumA[0] = tmpSum;
        for (int i = 1; i <= aLength; i++) {
            tmpSum += Integer.parseInt(st.nextToken());
            sumA[i] = tmpSum;
        }
    }

    private static void initializeB(BufferedReader br) throws IOException {
        StringTokenizer st;
        long tmpSum;
        int bLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        tmpSum = 0;
        sumB = new long[bLength + 1];
        sumB[0] = tmpSum;
        for (int i = 1; i <= bLength; i++) {
            tmpSum += Integer.parseInt(st.nextToken());
            sumB[i] = tmpSum;
        }
    }
}
