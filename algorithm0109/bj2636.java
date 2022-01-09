package algorithm0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2636 {
    
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};
    public static int bfs(int y,int x) {
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> cheeseque = new LinkedList<>();

        que.offer(new int[] { 0, 0 });
        visited[0][0] = true;
        int cheeseCount = 0;
        while (!que.isEmpty()) {

            int[] pos = que.poll();

            for (int i = 0; i < 4; i++) {
                int tempy = pos[0] + dirY[i];
                int tempx = pos[1] + dirX[i];

                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && !visited[tempy][tempx]) {
                    if (map[tempy][tempx] == 0) {
                        que.offer(new int[] { tempy, tempx });
                        visited[tempy][tempx] = true;
                    } else {
                        cheeseCount++;
                        visited[tempy][tempx] = true;
                        cheeseque.offer(new int[] { tempy, tempx });
                    }
                }
            }

        }

        while (!cheeseque.isEmpty()) {
            int[] temp = cheeseque.poll();
            map[temp[0]][temp[1]] = 0;
        }
        visited = new boolean[y][x];
        return cheeseCount;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        int cheese = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }
        int solution = 0;
        int check = 0;
        while (cheese > 0) {
            check++;
            int a = bfs(R, C);
            if (cheese - a == 0) {
                solution = cheese;
            }
            cheese -= a;
        }
        System.out.println(check+"\n"+solution);

    }
}
