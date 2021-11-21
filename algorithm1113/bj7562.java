package algorithm1113;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj7562{
    static int[] dirX = {-2,-1,1,2,2,1,-1,-2};
    static int[] dirY = {1,2,2,1,-1,-2,-2,-1};
    static int[][] map;
    static boolean[][] visited;
    static int[] endpoint = new int[2];

    static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{y, x});
        map[y][x] = 1;
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[1] == endpoint[0] && pos[0] == endpoint[1]){
                System.out.println(map[pos[0]][pos[1]]-1);
                return ;
            }
            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];
                if(tempY >=0 && tempX >= 0 && tempY < map.length && tempX < map.length && !visited[tempY][tempX]){
                    queue.offer(new int[]{tempY, tempX});
                    visited[tempY][tempX] = true;
                    map[tempY][tempX] = map[pos[0]][pos[1]]+1;
                    
                }
                
            }
        }
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < tc; i++) {
            int len = sc.nextInt();
            map = new int[len][len];
            visited = new boolean[len][len];
            sc.nextLine();
            String[] start = sc.nextLine().split(" ");
            String[] end = sc.nextLine().split(" ");
            endpoint[0] = Integer.parseInt(end[0]);
            endpoint[1] = Integer.parseInt(end[1]);
            int startY = Integer.parseInt(start[0]);
            int startX = Integer.parseInt(start[1]);

            bfs(startY,startX);


        }
    }
}