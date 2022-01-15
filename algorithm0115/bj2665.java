package algorithm0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2665{

    static class location{
        int y;
        int x;
        location(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static int[][] visited;
    public static int[][] map;
    public static int[] dirY = {-1,1,0,0};
    public static int[] dirX = {0,0,-1,1};

    public static void bfs(){
        Queue<location> que = new LinkedList<>();

        que.offer(new location(0,0));
        visited[0][0] = 0;
        while(!que.isEmpty()){
            location pos = que.poll();


            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];
                if(tempy >=0 && tempy< map.length && tempx >= 0 && tempx < map.length && visited[tempy][tempx] > visited[pos.y][pos.x]){
                    if(map[tempy][tempx] == 0){
                        visited[tempy][tempx] = visited[pos.y][pos.x]+1;
                        que.offer(new location(tempy, tempx));
                    }else{
                        visited[tempy][tempx] = visited[pos.y][pos.x];
                        que.offer(new location(tempy,tempx));
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = (int)temp.charAt(j)-'0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        System.out.println(visited[N-1][N-1]);
    }
}