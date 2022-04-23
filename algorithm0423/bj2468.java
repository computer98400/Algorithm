package algorithm0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj2468 {
    
    static class pos{
        int y;
        int x;

        pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }



    public static int[][] map;
    public static boolean[][] visited;
    public static boolean[][] check;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};
    
    public static int bfs(int y, int x, int height){
        Queue<pos> que = new LinkedList<>();
        visited[y][x] =true;
        que.add(new pos(y,x));
        while(!que.isEmpty()){
            pos test = que.poll();

            for(int i=0; i< dirY.length; i++){
                int tempY = test.y + dirY[i];
                int tempX = test.x + dirX[i];

                if(tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map.length && map[tempY][tempX] > height && !visited[tempY][tempX]){
                    visited[tempY][tempX] = true;
                    que.offer(new pos(tempY,tempX));
                }
            }
        }

        for(int i =0; i<map.length; i++){
            System.out.println(Arrays.toString(visited[i]));
        }
        return 1;
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        check = new boolean[N][N];
        int maxHeight = 0;
        for(int i =0; i< N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j =0; j<temp.length; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        int max = 0;
        for(int i=1; i< maxHeight; i++){
            visited = new boolean[N][N];
            int count = 0;
            for(int j =0; j<N; j++){
                for(int k=0; k< N;k++){
                    if(!visited[j][k]){
                        count += bfs(j,k,i);
                    }
                }
            }
            System.out.println(count);
        }



    }   
}
