import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class BOJ_11444 {
    static Map<Long, Long> map = new HashMap<>();
    static Long fiNum;
    final static Long DIVISION = 1000000007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fiNum = Long.parseLong(br.readLine());

        System.out.println(fiboCal(fiNum));
    }

    public static Long fiboCal(Long num){
        if(num == 0L) return 0L;
        if(num == 1L) return 1L;
        if (num == 2L) return 1L;
        if(map.containsKey(num)){
            return map.get(num);

        }
        if(num%2 == 0){
            long divNum = num / 2L;
            long temp1 = fiboCal(divNum - 1L);
            long temp2 = fiboCal(divNum);

            long numAns = ((2L * temp1 + temp2) * temp2)%DIVISION;
            map.put(num, numAns);
            return numAns;
        }
        else {
            long divNum = (num + 1) / 2;
            long temp1 = fiboCal(divNum);
            long temp2 = fiboCal(divNum - 1);

            long numAns = (temp1 * temp1 + temp2 * temp2) % DIVISION;
            map.put(num, numAns);
            return numAns;


        }

    }
}
