package programmers;
import java.util.Arrays;
import java.util.LinkedList;

public class 리코챗로봇 {

    class Solution {

        public final int[] dx = {1, -1 , 0 ,0};
        public final int[] dy = { 0, 0, 1, -1};

        public static int width;
        public static int height;



        public int solution(String[] board) {
            width = board[0].length();
            height = board.length;

            int startX=0;
            int startY=0;
            int endX=0;
            int endY=0;

            int[][] map = new int[height][width];


            for(int i = 0 ; i < height ; i++){
                Arrays.fill(map[i],0);
                for(int j = 0 ; j < width ; j++){
                    char now = board[i].charAt(j);
                    if(now == 'D'){
                        map[i][j] = -1;
                    }
                    else if(now == 'R'){
                        startX = j;
                        startY = i;
                    }
                    else if(now == 'G'){
                        endX = j;
                        endY = i;
                    }
                }
            }

            return bfs(map, startX, startY, endX, endY);
        }

        class Point{
            int x;
            int y;
            Point(int x, int y){
                this.x =x;
                this.y =y;
            }
        }

        private int bfs(int[][] map,
                        int startX,
                        int startY,
                        int endX,
                        int endY){

            boolean[][] visit = new boolean[height][width];

            LinkedList<Point> queue = new LinkedList<Point>();
            visit[startY][startX]= true;
            queue.add(new Point(startX, startY));


            while(queue.size() != 0){

                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                int score = map[y][x];

                if(y == endY && x == endX){
                    return score;
                }

                for(int i = 0 ; i < 4 ; i++) {
                    int nx = x;
                    int ny = y;


                    while((nx >= 0 && nx < width && ny >= 0 && ny < height)){
                        if(map[ny][nx] == -1 ){
                            break;
                        }
                        nx += dx[i];
                        ny += dy[i];
                    }

                    nx -= dx[i];
                    ny -= dy[i];

                    if(!visit[ny][nx]){
                        visit[ny][nx] = true;
                        map[ny][nx]= score + 1;
                        queue.add(new Point(nx, ny));
                    }
                    else {
                        continue;
                    }

                }
            }
            return -1;
        }
    }
}
