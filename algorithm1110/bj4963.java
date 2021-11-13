package Algorithm.algorithm1110;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj4963 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirX = { 0, 0, 1, -1 };
    public static int[] dirY = { 1, -1, 0, 0 };

    public static int land = 2;

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { j, i });
        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int k = 0; k < 4; k++) {
                int tempY = pos[0] + dirY[k];
                int tempX = pos[1] + dirX[k];

                if (tempY < 0 && tempY > map.length && tempX < 0 && tempX > map[0].length && !visited[tempY][tempX]
                        && map[tempY][tempX] == 1) {
                    q.offer(new int[] { tempY, tempX });
                    map[tempY][tempX] = land;
                    visited[tempY][tempX] = true;

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            sc.nextLine();
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[w][h];
            visited = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                String[] temp = sc.nextLine().split(" ");
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    bfs(i, j);
                    land++;
                }
            }
            int solution = -1;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    solution = Math.max(solution, map[i][j]);
                }
            }
            System.out.println("==========================");
            System.out.println(solution);
            land = 2;
        }
    }

}