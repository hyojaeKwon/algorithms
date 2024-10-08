import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();
        StringBuilder tBuilder = new StringBuilder(t);

        while(tBuilder.length() > s.length()) {
            if (tBuilder.charAt(tBuilder.length() - 1) == 'A') {
                tBuilder.deleteCharAt(tBuilder.length() - 1);
            }else {
                tBuilder.deleteCharAt(tBuilder.length() - 1);
                tBuilder.reverse();
            }
        }

        if (tBuilder.toString().equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

}
