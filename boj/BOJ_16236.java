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
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        // map 채우기
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int fish = Integer.parseInt(st.nextToken());
                map[i][j] = fish;
                if (fish != 0) {
                    if (fish == 9) {
                        sharkX = j;
                        sharkY = i;
                        map[i][j] = 0;
                    } else {
                        remain++;
                    }
                }
            }
        }

        // 가장 가까운 먹이 찾기
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
        int[] nearestFish = new int[3]; // [y,x] 형태로 넣습니다.
        boolean[][] visitMap = new boolean[size][size];
        Queue<Point> queue = new LinkedList<>();

        nearestFish[0] = sharkY;
        nearestFish[1] = sharkX;

        visitMap[sharkY][sharkX] = true;
        queue.add(new Point(sharkY, sharkX,0));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int nearest = size * size;

        while (!queue.isEmpty()) {

            Point polled = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];
                int time = polled.time;
                if (0 <= nx && nx < size && 0 <= ny && ny < size && !visitMap[ny][nx] && map[ny][nx] <= sharkSize) {
                    time = time + 1;
                    queue.add(new Point(ny, nx, time));
                    visitMap[ny][nx] = true;
                    if (map[ny][nx] != 0 && map[ny][nx] < sharkSize) {
                        if (time < nearest) {
                            nearestFish[0] = ny;
                            nearestFish[1] = nx;
                            nearest = time;
                        } else if (time == nearest && (ny <= nearestFish[0])) {
                            if (ny < nearestFish[0]) {
                                nearestFish[0] = ny;
                                nearestFish[1] = nx;
                                continue;
                            } else if (ny == nearestFish[0] && nx < nearestFish[1]) {
                                nearestFish[1] = nx;
                                continue;
                            }
                                nearestFish[0] = ny;
                                nearestFish[1] = nx;
                        }
                    }
                }
            }

        }
        nearestFish[2] = nearest;
        return nearestFish;

    }

    public static void move(int[] target) {
        map[target[0]][target[1]] = 0;

        sharkY = target[0];
        sharkX = target[1];
        remain--;
        if (++sizeUpCount == sharkSize) {
            sizeUpCount = 0;
            sharkSize++;
        }
    }

    public static class Point{
        public int y;
        public int x;
        public int time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
