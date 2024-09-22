import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197 {

    static int V, E;
    static int[] parent;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            parent[i] = i;
        }
        nodes = new Node[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(nodes, (o1, o2) -> (o1.value - o2.value));

        int mstVal = 0;
        for (Node node : nodes) {
            int from = node.from;
            int to = node.to;
            int value = node.value;
            

            if (findParent(from) == findParent(to)) {
                continue;
            }
            mstVal += value;
            union(from, to);
        }
        System.out.println(mstVal);
    }

    static int findParent(int v) {
        if (parent[v] == v) {
            return v;
        }
        return parent[v] = findParent(parent[v]);
    }

    static void union(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

    static class Node {
        public int from;
        public int to;
        public int value;
        Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public String toString() {
            return from + " " + to + " " + value;
        }
    }
}
