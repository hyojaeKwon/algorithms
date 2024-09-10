
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1406 {
    public static List<Character> list = new LinkedList<>();
    public static Queue<Control> queue = new LinkedList<>();
    static ListIterator<Character> listIterator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        int time = Integer.parseInt(br.readLine());
        for (int i = 0; i < time; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String controlString = st.nextToken();
            switch (controlString) {
                case "L" : queue.add(new Control((byte) 1)); break;
                case "D" : queue.add(new Control((byte) 2)); break;
                case "B" : queue.add(new Control((byte) 3)); break;
                default : queue.add(new Control((byte) 4, st.nextToken().charAt(0)));
            }
        }

        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }

        while (!queue.isEmpty()) {
            Control c = queue.poll();
            byte controlNum = c.controlNum;
            switch (controlNum) {
                case (byte) 1 : L(); break;
                case (byte) 2 : D(); break;
                case (byte) 3 : B(); break;
                default : P(c.target);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : list) {
            ans.append(character);
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void L() {
        if(listIterator.hasPrevious()) listIterator.previous();
    }
    public static void D() {
        if(listIterator.hasNext()) listIterator.next();
    }
    public static void B() {
        if(listIterator.hasPrevious()) {
            listIterator.previous();
            listIterator.remove();
        }
    }
    public static void P(char c) {
        listIterator.add(c);
    }

    public static class Control{
        byte controlNum;
        char target;
        public Control(byte controlNum, char target) {
            this.controlNum = controlNum;
            this.target = target;
        }
        public Control(byte controlNum) {
            this.controlNum = controlNum;
        }
    }
}
