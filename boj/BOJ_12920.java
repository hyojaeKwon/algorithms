import java.io.*;
import java.util.*;

public class BOJ_12920 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(0, 0));

        // 비트마스크를 생각하는게 중요하다.
        for(int i = 1; i <= number; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int satisfaction = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            int tmpQ = 1;
            while (quantity - tmpQ > 0) {
                items.add(new Item(satisfaction * tmpQ, weight * tmpQ));
                quantity -= tmpQ;
                tmpQ *= 2;
            }
            if (quantity != 0) {
                items.add(new Item(satisfaction * quantity, weight * quantity));
            }
        }

        int[][] dp = new int[items.size()][maxWeight+1];
        Arrays.fill(dp[0], 0);
        for(int i = 1  ; i < items.size(); i++) {
            for (int j = 1; j <= maxWeight ; j++) {
                if (j < items.get(i).weight) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items.get(i).weight] + items.get(i).value);
                }
            }
        }
        bw.write(dp[items.size()-1][maxWeight] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Item {
        int value;
        int weight;
        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}
