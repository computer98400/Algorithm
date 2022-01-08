package algorithm0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1600 {

    static class mongkey {
        int y;
        int x;
        int k;
        int time;
        mongkey(int y, int x, int k,int time) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.time = time;
        }

    }
    
    public static int[] dirY = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
    public static int[] dirX = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
    public static int[][] map;
    public static boolean[][] visited;


    public static void bfs(int K) {
        Queue<mongkey> que = new LinkedList<>();

        que.offer(new mongkey(0, 0, K, 0));
        visited[0][0] = true;
        while (!que.isEmpty()) {
            mongkey temp = que.poll();
            
            
            if (temp.y == map.length - 1 && temp.x == map[0].length - 1) {
                System.out.println(temp.time);
                return;
            }
            
            for (int i = 0; i < dirX.length; i++) {
                int tempy = temp.y + dirY[i];
                int tempx = temp.x + dirX[i];


                if (i >= 4 && tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length
                        && map[tempy][tempx] == 0 && !visited[tempy][tempx]) {
                    if (temp.k != 0) {
                        que.offer(new mongkey(tempy, tempx, temp.k - 1, temp.time + 1));
                        visited[tempy][tempx] = true;
                    }

                }
                if (i < 4 && tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && map[tempy][tempx] == 0 && !visited[tempy][tempx]) {
                    que.offer(new mongkey(tempy, tempx, temp.k, temp.time + 1));
                    visited[tempy][tempx] = true;
                }
            }

        }
        

        System.out.println(-1);
        return;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = Integer.MIN_VALUE;
                    visited[i][j] = true;
                }
            }
        }

        bfs(K);


    }
}
