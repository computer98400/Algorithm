package algorithm0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16234not_solved {
    
    public static int L;
    public static int R;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};


    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();

        int count = 1;
        int humans = 0;
        que.offer(new int[] { 0, 0 });
        visited[0][0] = true;
        humans += map[0][0];
        while (true) {


            while (!que.isEmpty()) {
                int[] pos = que.poll();

                for (int i = 0; i < 4; i++) {
                    int tempY = pos[0] + dirY[i];
                    int tempX = pos[1] + dirX[i];
                    //System.out.println("check");
                    if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map.length
                            && !visited[tempY][tempX]) {
                        int temp = Math.abs(map[pos[0]][pos[1]] - map[tempY][tempX]);
                        if (temp >= L && temp <= R) {
                            que.offer(new int[] { tempY, tempX });
                            visited[tempY][tempX] = true;
                            count++;
                            humans += map[tempY][tempX];
                        }
                    }
                }
            }
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited.length; j++) {
                    if (visited[i][j]) {
                        map[i][j] = humans / count;
                    }
                }
            }
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(map[i]));
            }



            
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // for (int j = 0; j < map.length; j++) {
        //     System.out.println(Arrays.toString(map[j]));
        // }
        //1. 각 맵에 가능한 범위를 표시.

        bfs();

    }
}
