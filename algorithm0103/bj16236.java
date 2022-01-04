package algorithm0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj16236 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int sharkSize = 2;
    public static int sharkCount = 0;
    public static shark pos;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};
    static class shark {
        int y;
        int x;
        int time;

        shark(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

    }

    public static PriorityQueue<shark> que = new PriorityQueue<>(new Comparator<shark>() {

        @Override
        public int compare(shark o1,shark o2) {
            if (o1.time == o2.time) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
            return o1.time - o2.time;
        }
        
    });

    public static void bfs() {
        int count = que.size();
        que.offer(pos);
        while (count > 0) {
            shark pos2 = que.poll();
            
            for (int i = 0; i < 4; i++) {
                int tempY = pos2.y + dirY[i];
                int tempX = pos2.x + dirX[i];

                if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map.length && map[tempY][tempX] != 0 && !visited[tempY][tempX]) {
                    que.offer(new shark(tempY, tempX, pos2.time + 1));
                    visited[tempY][tempX] = true;
                }
            }
            count--;
        }

    }

    public static int totalmove = 0;

    public static void checking() {
        if (!que.isEmpty()) {    
            shark temp = que.poll();
            if (map[temp.y][temp.x] < sharkSize) {
                totalmove += temp.time;
                que.clear();
                visited = new boolean[map.length][map.length];
                map[temp.y][temp.x] = 0;
                que.offer(new shark(temp.y, temp.x, 0));
                sharkCount++;
                if (sharkCount == sharkSize) {
                    sharkCount = 0;
                    sharkSize++;
                }
                return;
            } else {
                que.offer(temp);
                return;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    pos = new shark(i, j, 0);
                    visited[i][j] = true;
                }
            }
        }


    }
}
