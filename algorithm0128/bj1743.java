package algorithm0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1743 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1,1,0,0};
    static int[] dirX = { 0, 0, -1, 1 };
    static int trash = 0;
    static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[] {y,x});
        visited[y][x] = true;
        int count = 1;
        while (!que.isEmpty()) {
            int[] pos = que.poll();

            for (int i = 0; i < dirY.length; i++) {
                int tempy = pos[0] + dirY[i];
                int tempx = pos[1] + dirX[i];

                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && !visited[tempy][tempx]) {
                    que.offer(new int[] { tempy, tempx });
                    count++;
                    visited[tempy][tempx] = true;
                }
            }
        }

        trash = Math.max(trash, count);

    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(trash);
}
}
