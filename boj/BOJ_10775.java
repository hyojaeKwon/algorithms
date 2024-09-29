import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10775 {

    static int[] gateArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gates = Integer.parseInt(br.readLine());
        gateArr = new int[gates + 1];
        for(int i = 0; i <= gates; i++) {
            gateArr[i] = i;
        }

        int planes = Integer.parseInt(br.readLine());

        int result = 0 ;

        for(int i = 0; i < planes; i++) {
            int now = Integer.parseInt(br.readLine());
            int parent = findParent(now);
            if (parent == 0) {
                break;
            }else {
                result++;
                makeUnion(parent - 1, parent);
            }

        }

        System.out.println(result);
    }

    private static int findParent(int target) {
        if(gateArr[target] == target) return target;
        return gateArr[target] = findParent(gateArr[target]);
    }

    private static void makeUnion(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        gateArr[parentB] = parentA;
    }
}
