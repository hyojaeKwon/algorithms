import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        PriorityQueue<Pipe> pipes = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pipes.add(new Pipe(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        int answer = 0;
        while (!pipes.isEmpty()) {
            Pipe pipe = pipes.poll();
            if (find(pipe.from) == find(pipe.to)) {
                continue;
            }
            union(pipe.from, pipe.to);
            count++;
            answer += pipe.weight;
            if (count == n) {
                break;
            }
        }
        System.out.println(answer);

    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        parent[parentA] = parentB;
    }

    static class Pipe implements Comparable<Pipe> {
        int from;
        int to;
        int weight;

        Pipe(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pipe o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
