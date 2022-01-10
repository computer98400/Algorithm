package algorithm0110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1926 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirX = {0,0,-1,1};
    public static int[] dirY = {-1,1,0,0};

    static class paint {
        int y;
        int x;


        paint(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }

    public static int count = 0;
    public static int check = 0;
    public static int solution = 0;
    public static void bfs(int y, int x) {
        Queue<paint> que = new LinkedList<>();

        que.offer(new paint(y,x));
        visited[y][x] = true;
        int test = 0;
        while (!que.isEmpty()) {
            paint pos = que.poll();
            test++;
            if (test > check) {
                check = test;
            }
            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];
            
                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && !visited[tempy][tempx]) {
                    que.offer(new paint(tempy, tempx));
                    visited[tempy][tempx] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (visited[i][j] == false) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count+"\n"+check);

    }
}
