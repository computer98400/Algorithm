package algorithm0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1937 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = { -1, 1, 0, 0 };
    static int[] dirX = { 0, 0, -1, 1 };
    static int test = 0;
    static int[][] dp;
    static class obj {
        int y;
        int x;
        int count;

        obj(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

    }

    public static int dfs(int y, int x) {
        
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 1;
        for (int i = 0; i < dirX.length; i++) {

            int tempy = y + dirY[i];
            int tempx = x + dirX[i];

            if (tempy >= 0 && tempx >= 0 && tempy < map.length && tempx < map.length && map[y][x] < map[tempy][tempx]) {
                dp[y][x] = Math.max(dp[y][x], dfs(tempy, tempx)+1);
            }
        }

        return dp[y][x];
    }


    public static void bfs(int y, int x) {
        Queue<obj> que = new LinkedList<>();
        que.offer(new obj(y, x, 1));
        visited[y][x] = true;
        while (!que.isEmpty()) {
            obj pos = que.poll();

            for (int i = 0; i < dirX.length; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];

                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length
                        && map[pos.y][pos.x] < map[tempy][tempx] && !visited[tempy][tempx]) {
                    que.offer(new obj(tempy, tempx, pos.count + 1));
                    visited[tempy][tempx] = true;
                    test = Math.max(test, pos.count + 1);
                }
            }
        }
    }

    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                test = Math.max(test,dfs(i, j));

                // for (int j2 = 0; j2 < map.length; j2++) {
                //     System.out.println(Arrays.toString(dp[j2]));
                // }
                // visited = new boolean[N][N];

               // System.out.println("===================");
            }
        }

        System.out.println(test);
    }




}
