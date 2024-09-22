import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1647 {

    static int N, M; // N:집의 갯수, M:길의 갯수
    static Node[] nodes;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new Node[M];
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes, (o1, o2) -> o1.value - o2.value);


        int value = 0;
        int maxVal = 0;
        for (Node node : nodes) {
            if (findParent(node.from) == findParent(node.to)) {
                continue;
            }
            value += node.value;
            makeUnion(node.from, node.to);
            maxVal = node.value;
        }
        System.out.println(value - maxVal);

    }

    static int findParent(int target) {
        if (parent[target] == target) {
            return target;
        }
        return parent[target] = findParent(parent[target]);
    }

    static void makeUnion(int targetA, int targetB) {
        int parentA = findParent(targetA);
        int parentB = findParent(targetB);
        parent[parentA] = parentB;
    }



    public static class Node {
        public int from;
        public int to;
        public int value;
        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
