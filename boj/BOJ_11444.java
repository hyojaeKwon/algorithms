import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Java의 map은 String으로 저장한다는데 참고해서 오류 해결하기
 */
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

        if(num == 0) return 0L;
        if(num == 1) return 1L;
        if (num == 2) return 1L;
        if(map.containsKey(num)){
            return map.get(num);

        }
        if(num%2 == 0){
            long divNum = num / 2;
            long temp1 = fiboCal(num - 1);
            long temp2 = fiboCal(num);

            long numAns = ((2L * temp1 + temp2) * temp2)/DIVISION;
            map.put(num, numAns);
            return num;
        }
        else {
            long divNum = (num + 1) / 2;
            long temp1 = fiboCal(divNum);
            long temp2 = fiboCal(divNum - 1);

            long numAns = (temp1 * temp1 + temp2 * temp2) / DIVISION;
            map.put(num, numAns);
            return numAns;


        }

    }
}
