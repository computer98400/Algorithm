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
            //맵 변경을 무조건 안해야됨
            //재방문시 표시된 시간보다 작을때 갱신
            //벽 넘어서 이동하기?
            //사용자 입력에서 받는 뛰는 갯수
            //4방탐색 + 뛴자리 = 재방문시 표시된 시간 작을때 갱신
            //4방탐색 + 위아래
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
