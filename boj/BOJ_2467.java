import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = arr.length-1;
        int lVal = arr[l];
        int rVal = arr[r];
        int min = Integer.MAX_VALUE;

        while(l<r) {
            int llVal = arr[l];
            int rrVal = arr[r];
            int currentVal = llVal + rrVal;
            if (Math.abs(currentVal) < min) {
                min = Math.abs(currentVal);
                lVal = llVal;
                rVal = rrVal;
            }
            if(currentVal < 0) {
                l++;
            }else {
                r--;
            }

        }
        bw.write(lVal + " " + rVal + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
