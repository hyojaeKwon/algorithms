import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1038 {

    private static final List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 함수를 통해 감소하는 숫자만 모은 list를 만든다.
        for (int i = 0; i < 10; i++) {
            makeDescendingList(i);
        }
        list.sort(Long::compareTo);

        // n번째 감소하는 수가 존재하지 않을 때 / 가장 큰 감소하는 수는 9876543210이다.
        if (n >= list.size()) {
            System.out.println(-1);
        }else{
            System.out.println(list.get(n));
        }
    }

    private static void makeDescendingList(long num) {
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            makeDescendingList((num * 10) + i);
        }
    }
}
