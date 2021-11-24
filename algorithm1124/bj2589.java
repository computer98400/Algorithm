package algorithm1124;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj2589 {
    static int[] dirY = {0,0,-1,1};
    static int[] dirX = {-1,1,0,0};
    static int[][] map;
    static int[][] copymap;
    static boolean[][] visited;
    static boolean[][] copyvisited;


    static int bfs(int y, int x) {    
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { y, x });
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];

                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !visited[tempY][tempX]) {
                    queue.offer(new int[] { tempY, tempX });
                    map[tempY][tempX] = map[pos[0]][pos[1]] + 1;
                    visited[tempY][tempX] = true;
                }
            }
        }
        int solution = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                solution = Math.max(solution, map[i][j]);
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();
        map = new int[y][x];
        visited = new boolean[y][x];
        copyvisited = new boolean[y][x];
        copymap = new int[y][x];

        for (int i = 0; i < y; i++) {
            String temp = sc.nextLine();

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'W') {
                    map[i][j] = 1;
                    copymap[i][j] = 1;
                    visited[i][j] = true;
                    copyvisited[i][j] = true;
                } else {
                    map[i][j] = 0;
                    copymap[i][j] = 0;
                }
            }
        }
        int solution = Integer.MIN_VALUE;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    solution = Math.max(solution,bfs(i,j));
                }
                for (int j2 = 0; j2 < map.length; j2++) {
                    for (int k = 0; k < map[0].length; k++) {
                        map[j2][k] = copymap[j2][k];
                        visited[j2][k] = copyvisited[j2][k];
                    } 
                }
            }
        }

        System.out.println(solution);

    }


}