import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12100 {

    private static final Map<String, Integer> visited = new HashMap<>();
    private static int maxBlockValue = 0;

    public static void main(String[] args) throws IOException {
        int[][] map = initialize();
        simulate(0, map);
        System.out.println(maxBlockValue);
    }

    private static void simulate(int depth, int[][] map) {
        if (depth == 5) {
            updateMaxValue(map);
            return;
        }
        if (isOptimizationApplicable(depth, map)) return;

        int[][] originalMap = copyMap(map);

        simulate(depth + 1, moveUpOrLeft(map, true)); // 위
        restoreMap(map, originalMap);
        simulate(depth + 1, moveDownOrRight(map, true)); // 아래
        restoreMap(map, originalMap);
        simulate(depth + 1, moveDownOrRight(map, false)); // 오른쪽
        restoreMap(map, originalMap);
        simulate(depth + 1, moveUpOrLeft(map, false)); // 왼쪽
        restoreMap(map, originalMap);
    }

    private static boolean isOptimizationApplicable(int depth, int[][] map) {
        return isAlreadyVisited(map, depth) || !canExceedMaxValue(map, depth);
    }

    private static boolean isAlreadyVisited(int[][] map, int depth) {
        String key = convertMapToString(map);
        if (visited.containsKey(key)) {
            if (visited.get(key) > depth) {
                visited.put(key, depth);
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean canExceedMaxValue(int[][] map, int depth) {
        int currentMax = getMaxValue(map);
        int maxPossible = currentMax * (1 << (5 - depth));
        return maxPossible > maxBlockValue;
    }

    private static int[][] moveUpOrLeft(int[][] map, boolean isVertical) {
        for (int i = 0; i < map.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            extractAndMergeBlocks(map, isVertical, i, queue, true);
            fillBlocks(map, isVertical, i, queue, true);
        }
        return map;
    }

    private static int[][] moveDownOrRight(int[][] map, boolean isVertical) {
        for (int i = 0; i < map.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            extractAndMergeBlocks(map, isVertical, i, queue, false);
            fillBlocks(map, isVertical, i, queue, false);
        }
        return map;
    }

    private static void extractAndMergeBlocks(int[][] map, boolean isVertical, int index, Queue<Integer> queue, boolean isForward) {
        int temp = 0;
        int size = map.length;
        int start = isForward ? 0 : size - 1;
        int end = isForward ? size : -1;
        int step = isForward ? 1 : -1;

        for (int j = start; j != end; j += step) {
            int value = isVertical ? map[j][index] : map[index][j];
            if (value == 0) continue;

            if (temp == 0) {
                temp = value;
            } else if (temp == value) {
                queue.add(temp * 2);
                temp = 0;
            } else {
                queue.add(temp);
                temp = value;
            }
        }
        if (temp != 0) queue.add(temp);
    }

    private static void fillBlocks(int[][] map, boolean isVertical, int index, Queue<Integer> queue, boolean isForward) {
        int size = map.length;
        int start = isForward ? 0 : size - 1;
        int end = isForward ? size : -1;
        int step = isForward ? 1 : -1;

        for (int j = start; j != end; j += step) {
            int value = queue.isEmpty() ? 0 : queue.poll();
            if (isVertical) {
                map[j][index] = value;
            } else {
                map[index][j] = value;
            }
        }
    }

    private static int getMaxValue(int[][] map) {
        int maxValue = 0;
        for (int[] row : map) {
            for (int value : row) {
                maxValue = Math.max(maxValue, value);
            }
        }
        return maxValue;
    }

    private static void updateMaxValue(int[][] map) {
        maxBlockValue = Math.max(maxBlockValue, getMaxValue(map));
    }

    private static int[][] copyMap(int[][] map) {
        int size = map.length;
        int[][] newMap = new int[size][size];
        for (int i = 0; i < size; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, size);
        }
        return newMap;
    }

    private static void restoreMap(int[][] map, int[][] originalMap) {
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(originalMap[i], 0, map[i], 0, map[i].length);
        }
    }

    private static String convertMapToString(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int value : row) {
                sb.append(value).append(".");
            }
        }
        return sb.toString();
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
}