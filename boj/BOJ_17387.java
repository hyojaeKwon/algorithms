import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17387 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Segment s1 = readSegment(br);
        Segment s2 = readSegment(br);
        System.out.println(segmentsIntersect(s1, s2) ? 1 : 0);
    }

    private static Segment readSegment(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        return new Segment(
                new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())),
                new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()))
        );
    }

    private static boolean segmentsIntersect(Segment s1, Segment s2) {
        long cross1 = crossProduct(s1.p1, s1.p2, s2.p1) * crossProduct(s1.p1, s1.p2, s2.p2);
        long cross2 = crossProduct(s2.p1, s2.p2, s1.p1) * crossProduct(s2.p1, s2.p2, s1.p2);

        if (cross1 == 0 && cross2 == 0) {
            return segmentsOverlap(s1, s2);
        }
        return cross1 <= 0 && cross2 <= 0;
    }

    private static boolean segmentsOverlap(Segment s1, Segment s2) {
        return Math.min(s1.p1.x, s1.p2.x) <= Math.max(s2.p1.x, s2.p2.x) &&
                Math.min(s2.p1.x, s2.p2.x) <= Math.max(s1.p1.x, s1.p2.x) &&
                Math.min(s1.p1.y, s1.p2.y) <= Math.max(s2.p1.y, s2.p2.y) &&
                Math.min(s2.p1.y, s2.p2.y) <= Math.max(s1.p1.y, s1.p2.y);
    }

    private static long crossProduct(Point a, Point b, Point c) {
        long value = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return Long.compare(value, 0);
    }

    static class Segment {
        final Point p1, p2;
        public Segment(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    static class Point {
        final long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}