package algorithm1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4963 {
    public static int[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> que;
    public static int[] dirX = {-1,0,1,-1,1,-1,0,1};
    public static int[] dirY = {-1,-1,-1,0,0,1,1,1};
    public static int check;
    public static void bfs(int y, int x) {
        
        que.offer(new int[] { y, x });
        visited[y][x] = true;
        map[y][x] = check;

        while (!que.isEmpty()) {
            int[] pos = que.poll();
            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];

                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !visited[tempY][tempX]
                        && map[tempY][tempX] == 1) {
                    que.offer(new int[] { tempY, tempX });
                    visited[tempY][tempX] = true;
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        while (true) {
            
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            } 
            
            
            map = new int[M][N];
            visited = new boolean[M][N];
            que = new LinkedList<>();
            check = 0;
            
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        check++;
                    }
                }
            }
            // for (int i = 0; i < map.length; i++) {
            //     System.out.println(Arrays.toString(map[i]));
            // }
            System.out.println(check);
        }
    }
}
