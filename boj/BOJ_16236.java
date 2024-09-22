import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

    public static int size;
    public static int[][] map;
    public static int sharkX, sharkY;
    public static int sharkSize = 2;
    public static int time = 0;
    public static int remain = 0;
    public static int sizeUpCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int fish = Integer.parseInt(st.nextToken());
                map[i][j] = fish;
                if (fish == 9) {
                    sharkX = j;
                    sharkY = i;
                    map[i][j] = 0;
                } else if (fish > 0) {
                    remain++;
                }
            }
        }

        while (remain > 0) {
            int[] nearFish = findNearestFish();
            if (nearFish[0] == sharkY && nearFish[1] == sharkX) {
                break;
            }
            time += nearFish[2];
            move(nearFish);
        }

        System.out.println(time);
    }

    public static int[] findNearestFish() {
        int[] nearestFish = {sharkY, sharkX, Integer.MAX_VALUE};
        boolean[][] visitMap = new boolean[size][size];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sharkY, sharkX, 0));
        visitMap[sharkY][sharkX] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Point polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];
                int time = polled.time + 1;

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && !visitMap[ny][nx] && map[ny][nx] <= sharkSize) {
                    visitMap[ny][nx] = true;
                    queue.add(new Point(ny, nx, time));

                    if (map[ny][nx] > 0 && map[ny][nx] < sharkSize) {
                        if (time < nearestFish[2] ||
                                (time == nearestFish[2] && (ny < nearestFish[0] ||
                                        (ny == nearestFish[0] && nx < nearestFish[1])))) {
                            nearestFish[0] = ny;
                            nearestFish[1] = nx;
                            nearestFish[2] = time;
                        }
                    }
                }
            }
        }

        return nearestFish;
    }

    public static void move(int[] target) {
        map[target[0]][target[1]] = 0;
        sharkY = target[0];
        sharkX = target[1];
        remain--;
        sizeUpCount++;

        if (sizeUpCount == sharkSize) {
            sharkSize++;
            sizeUpCount = 0;
        }
    }

    public static class Point {
        public int y, x, time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
