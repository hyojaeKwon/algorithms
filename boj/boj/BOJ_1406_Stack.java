import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> ls = new Stack<>();
        Stack<Character> rs = new Stack<>();

        String st = br.readLine();
        for(int i = 0; i < st.length(); i++) {
            ls.push(st.charAt(i));
        }

        int time = Integer.parseInt(br.readLine());
        for(int i = 0; i < time; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            char controlChar  = input.nextToken().charAt(0);
            switch (controlChar){
                case 'L':
                    if(!ls.empty()) rs.push(ls.pop());
                    break;
                case 'D':
                    if(!rs.empty()) ls.push(rs.pop());
                    break;
                case 'B':
                    if(!ls.empty()) ls.pop();
                    break;
                default:
                    String inputChar = input.nextToken();
                    ls.push(inputChar.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!ls.empty()) {
            rs.push(ls.pop());
        }
        while (!rs.empty()) {
            sb.append(rs.pop());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
