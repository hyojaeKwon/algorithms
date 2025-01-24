import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12100 {

    private static final Map<String, Integer> visited = new HashMap();
    private static int MAX = 0;

    public static void main(String[] args) throws IOException {
        int[][] map = initialize();
        simulate(0, map);
        System.out.println(MAX);
    }

    private static void simulate(int depth, int[][] map) {
        if (depth == 5) {
            getMaxValue(map);
            return;
        }
        if (optimization(depth, map)) return;

        int[][] originalMap = copyMap(map);

        simulate(depth + 1, forward(map, true));
        restoreMap(map, originalMap);
        simulate(depth + 1, reverse(map, true));
        restoreMap(map, originalMap);
        simulate(depth + 1, reverse(map, false));
        restoreMap(map, originalMap);
        simulate(depth + 1, forward(map, false));
        restoreMap(map, originalMap);
    }

    private static boolean optimization(int depth, int[][] map) {
        if (isVisitedMap(map, depth)) return true;
        return pruningMap(depth, map);
    }

    private static boolean pruningMap(int depth, int[][] map) {
        return !isPossibleToGetNewMax(map, depth);
    }

    private static boolean isVisitedMap(int[][] map, int depth) {
        String mapStringValue = getMapStringValue(map);
        if (visited.containsKey(mapStringValue)) {
            if (visited.get(mapStringValue) > depth) {
                visited.put(mapStringValue, depth);
                return false;
            }
            return true;
        }
        return false;
    }

    private static String getMapStringValue(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int value : row) {
                sb.append(value).append(".");
            }
        }
        return sb.toString();
    }

    private static boolean isPossibleToGetNewMax(int[][] map, int depth) {
        int currentMax = getMaxValue(map);
        int maxPossibleValue = (int) (currentMax * (Math.pow(2, 5 - depth)));
        return maxPossibleValue > MAX;
    }

    private static int[][] forward(int[][] map, boolean isVertical) {
        for (int i = 0; i < map.length; i++) {
            Queue<Integer> q = new LinkedList<>();
            int tmp = 0;
            checkArrayForward(isVertical, map, tmp, i, q);
            fillArrayForward(isVertical, map, i, q);
        }
        return map;
    }

    private static int[][] reverse(int[][] map, boolean isVertical) {
        for (int i = 0; i < map.length; i++) {
            Queue<Integer> q = new LinkedList<>();
            int tmp = 0;
            checkArrayReverse(map, isVertical, tmp, i, q);
            fillArrayReverse(map, isVertical, i, q);
        }
        return map;
    }

    private static void checkArrayReverse(int[][] map, boolean isVertical, int tmp, int i, Queue<Integer> q) {
        for (int j = map.length - 1; j >= 0; j--) {
            tmp = checkArray(map, isVertical, tmp, j, i, q);
        }
        if (tmp != 0) q.add(tmp);
    }

    private static int checkArray(int[][] map, boolean isVertical, int tmp, int j, int i, Queue<Integer> q) {
        if (isVertical) {
            return calculate(map, j, i, tmp, q);
        }
        return calculate(map, i, j, tmp, q);
    }

    private static void fillArrayReverse(int[][] map, boolean isVertical, int i, Queue<Integer> q) {
        for (int j = map.length - 1; j >= 0; j--) {
            fillArray(isVertical, map, i, q, j);
        }
    }


    private static void checkArrayForward(boolean isVertical, int[][] map, int tmp, int i, Queue<Integer> q) {
        for (int j = 0; j < map.length; j++) {
            tmp = checkArray(map, isVertical, tmp, j, i, q);
        }
        if (tmp != 0) q.add(tmp);
    }

    private static void fillArrayForward(boolean isVertical, int[][] map, int i, Queue<Integer> q) {
        for (int j = 0; j < map.length; j++) {
            fillArray(isVertical, map, i, q, j);
        }
    }

    private static void fillArray(boolean isVertical, int[][] map, int i, Queue<Integer> q, int j) {
        if (isVertical) {
            map[j][i] = q.isEmpty() ? 0 : q.poll();
            return;
        }
        map[i][j] = q.isEmpty() ? 0 : q.poll();
    }

    private static int calculate(int[][] map, int j, int i, int tmp, Queue<Integer> q) {
        if (map[j][i] == 0) {
            return tmp;
        }
        if (tmp == 0) {
            tmp = map[j][i];
            return tmp;
        }
        if (map[j][i] != tmp) {
            q.add(tmp);
            tmp = map[j][i];
            return tmp;
        }
        q.add(tmp * 2);
        tmp = 0;
        return tmp;
    }

    private static int getMaxValue(int[][] map) {
        int maxValue = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > maxValue) {
                    maxValue = map[i][j];
                }
            }
        }
        if (MAX < maxValue) {
            MAX = maxValue;
        }
        return maxValue;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, map[i].length);
        }
        return newMap;
    }

    private static void restoreMap(int[][] map, int[][] originalMap) {
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(originalMap[i], 0, map[i], 0, map[i].length);
        }
    }

    private static int[][] initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }

    static class MapState {
        String mapString;
        int depth;

        public int getDepth() {
            return depth;
        }

        public String getMapString() {
            return mapString;
        }
    }
}
