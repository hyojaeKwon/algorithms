import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (isGoodNumber(i, arr)) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
    }

    private static boolean isGoodNumber(int index, int[] arr) {
        int start = 0;
        int rear = arr.length - 1;
        while (start < rear) {
            long sum = arr[start] + arr[rear];
            if (sum == arr[index]) {
                if (index == start) {
                    start++;
                }else if(index == rear){
                    rear--;
                }else{
                    return true;
                }
            } else if (sum > arr[index]) {
                rear--;
            } else{
                start++;
            }
        }
        return false;
    }
}
