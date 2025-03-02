package programmers;

import java.util.*;

public class 퍼즐조각채우기 {

    class Solution {

        public int[] dx = {1, -1, 0, 0};
        public int[] dy = {0, 0, 1, -1};

        public int solution(int[][] game_board, int[][] table) {
            List<List<int[]>> emptySpace = new ArrayList<>();
            List<List<int[]>> block = new ArrayList<>();

            int row = game_board.length;
            int col = game_board[0].length;
            boolean[][] visit = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visit[i][j] && game_board[i][j] == 0) {
                        emptySpace.add(find(j, i, game_board, visit, 0));
                    }
                }
            }

            row = table.length;
            col = table[0].length;
            visit = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!visit[i][j] && table[i][j] == 1) {
                        block.add(find(j, i, table, visit, 1));
                    }
                }
            }

            normalize(emptySpace);
            normalize(block);

            int result = 0;
            boolean[] used = new boolean[block.size()];

            for (List<int[]> ints : emptySpace) {
                for (int j = 0; j < block.size(); j++) {
                    if (used[j]) {
                        continue;
                    }

                    List<int[]> currentBlock = block.get(j);
                    if (compare(ints, currentBlock)) {
                        used[j] = true;
                        result += currentBlock.size();
                        break;
                    }
                }
            }
            return result;
        }


        public boolean compare(List<int[]> space, List<int[]> target) {
            if (space.size() != target.size()) {
                return false;
            }
            List<int[]> block = target;
            for (int i = 0; i < 4; i++) {
                if (compareTwo(space, block)) {
                    return true;
                }

                block = rotate(block);
            }

            return false;
        }

        public List<int[]> rotate(List<int[]> target) {
            // 돌리고 정규화
            int minX = 50;
            int minY = 50;
            List<int[]> result = new ArrayList<>();

            for (int[] tmp : target) {
                minX = Math.min(minX, -tmp[0]);
                minY = Math.min(minY, tmp[1]);

                result.add(new int[]{tmp[1], -tmp[0]});
            }

            for (int[] tmp : result) {
                tmp[0] -= minY;
                tmp[1] -= minX;
            }

            return result;

        }

        public boolean compareTwo(List<int[]> space, List<int[]> target) {
            // 정렬
            space.sort((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            target.sort((o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            // 하나씩 비교
            for (int i = 0; i < target.size(); i++) {
                int[] sTmp = space.get(i);
                int[] bTmp = target.get(i);
                if (sTmp[0] != bTmp[0] || bTmp[1] != sTmp[1]) {
                    return false;
                }
            }
            return true;
        }

        public void normalize(List<List<int[]>> target) {
            for (List<int[]> tmp : target) {
                int minX = 50;
                int minY = 50;

                for (int[] tmpp : tmp) {
                    minX = Math.min(minX, tmpp[1]);
                    minY = Math.min(minY, tmpp[0]);
                }
                for (int[] tmpp : tmp) {
                    tmpp[1] -= minX;
                    tmpp[0] -= minY;
                }
            }
        }

        public List<int[]> find(int sx, int sy, int[][] map, boolean[][] visit, int target) {
            List<int[]> result = new ArrayList<>();
            Queue<int[]> queue = new LinkedList<>();
            visit[sy][sx] = true;
            result.add(new int[]{sy, sx});
            queue.add(new int[]{sy, sx});
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp[1] + dx[i];
                    int ny = tmp[0] + dy[i];
                    if (0 <= nx && 0 <= ny && nx < map.length && ny < map[0].length) {
                        if (!visit[ny][nx] && map[ny][nx] == target) {
                            queue.add(new int[]{ny, nx});
                            visit[ny][nx] = true;
                            result.add(new int[]{ny, nx});
                        }
                    }
                }
            }
            return result;
        }
    }
}
