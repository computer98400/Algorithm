package algorithm1215;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7562 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirY = { -1, -2, -2, -1, 1, 2, 2, 1 };
    public static int[] dirX = { -2, -1, 1, 2, 2, 1, -1, -2 };
    public static int endY;
    public static int endX;

    public static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] { y, x, 0 });

        while (!que.isEmpty()) {
            
            int[] pos = que.poll();

            if (pos[0] == endY && pos[1] == endX) {
                System.out.println(pos[2]);
                return;
            }

            for (int i = 0; i < dirY.length; i++) {
                
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];

                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map.length && !visited[tempY][tempX]) {
                    que.offer(new int[] { tempY, tempX, pos[2]+1 });
                    visited[tempY][tempX] = true;
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tc = sc.nextInt();

        for (int i = 0; i < Tc; i++) {
            int N = sc.nextInt();
            int startY = sc.nextInt();
            int startX = sc.nextInt();
            endY = sc.nextInt();
            endX = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[N][N];
    
            bfs(startY, startX);
            
        }

    }
}
