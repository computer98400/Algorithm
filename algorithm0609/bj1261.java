package algorithm0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1261 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirY = {0,0,-1,1};
    public static int[] dirX = {-1,1,0,0};
    public static int min = Integer.MAX_VALUE;
    public static void bfs() {

        PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }           
        });
        que.offer(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int[] current = que.poll();

            if (current[0] == map.length - 1 && current[1] == map[0].length - 1) {
                System.out.println(current[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                
                int ty = current[0] + dirY[i];
                int tx = current[1] + dirX[i];

                if (ty >= 0 && ty < map.length && tx >= 0 && tx < map[0].length && !visited[ty][tx]) {
                    int temp = current[2];
                    if (map[ty][tx] == 1) {
                        temp++;
                    }
                    que.offer(new int[] { ty, tx, temp });
                    visited[ty][tx] = true;

                }

            }

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < map.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = temp.charAt(j) - '0';

            }
        }

        bfs();
    }
}
