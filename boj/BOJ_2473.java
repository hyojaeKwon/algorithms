import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        int mLeft = 0;
        int mRight = 0;
        int mMid = 0;
        long min = Long.MAX_VALUE;

        while (left < right) {
            long tmpMin = min;
            long tmpMax = 0;

            for (int i = left + 1; i < right; i++) {
                long lNum = arr[left];
                long rNum = arr[right];
                long mNum = arr[i];
                long tmp = rNum + lNum + mNum;
                if(Math.abs(tmp) > Math.abs(tmpMax)) {
                    tmpMax = tmp;
                }
                if(Math.abs(tmp) < Math.abs(tmpMin)) {
                    tmpMin = tmp;
                    mLeft = left;
                    mRight = right;
                    mMid = i;
                } else if (tmp == 0) {
                    System.out.println(arr[left] + " " + arr[i] + " " + arr[right]);
                    return;
                }
            }
            if (tmpMax > 0) {
                right--;
            }else{
                left++;
            }
            min = tmpMin;
        }
        System.out.println(arr[mLeft] + " " + arr[mMid] + " " + arr[mRight]);
    }
}
