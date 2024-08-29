import java.io.*;
import java.util.*;

public class BOJ_1202 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewel = Integer.parseInt(st.nextToken());
        int bag = Integer.parseInt(st.nextToken());

        ArrayList<Item> jewels = new ArrayList<>();

        PriorityQueue<Integer> bags = new PriorityQueue<>();

        for (int i = 0; i < jewel; i++) {
            st = new StringTokenizer(br.readLine());
            int jWeight = Integer.parseInt(st.nextToken());
            int jPrice = Integer.parseInt(st.nextToken());
            jewels.add(new Item(jWeight, jPrice));
        }
        jewels.sort(((o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o1.price - o2.price;
            } else return o1.weight - o2.weight;
        }));

        for(int i = 0; i < bag; i++) {
            int bagCapacity = Integer.parseInt(br.readLine());
            bags.add(bagCapacity);
        }

        long result = 0;
        PriorityQueue<Integer> pqJewels = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        while (!bags.isEmpty()) {
            Integer capacity = bags.poll();
            while(j < jewel){
                if (jewels.get(j).weight > capacity) {
                    break;
                }
                pqJewels.add(jewels.get(j++).price);
            }
            if(!pqJewels.isEmpty()) {
                Integer poll = pqJewels.poll();
                result += poll;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    static class Item {
        int weight;
        int price;
        Item(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }
}
