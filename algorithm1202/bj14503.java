package Algorithm.algorithm1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * bj14503
 */
public class bj14503 {
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dirY = {0,0,1,-1};
    public static int[] dirX = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        visited = new boolean[Y][X];
        map = new int[Y][X];

        st = new StringTokenizer(br.readLine()," ");
        int cleanY = Integer.parseInt(st.nextToken());
        int cleanX = Integer.parseInt(st.nextToken());
        for (int i = 0; i < Y; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(cleanY,cleanX);
        int count =0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 3){
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void bfs(int y, int x){
        Queue<int[]> test = new LinkedList<>();
        test.offer(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = 3;
        while(!test.isEmpty()){
            int[] pos = test.poll();
            for(int i=0;i<4; i++){
                int tempY = pos[0]+ dirY[i];
                int tempX = pos[1]+ dirX[i];
                
                if(tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length && !visited[tempY][tempX] && map[tempY][tempX] == 0){
                    test.offer(new int[]{tempY,tempX});
                    visited[tempY][tempX] = true;
                    map[tempY][tempX] = 3;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}