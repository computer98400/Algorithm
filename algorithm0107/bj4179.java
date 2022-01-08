package algorithm0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj4179 {
    
    static Queue<int[]> fire;
    static Queue<state> sanggun;
    static int[] dirY = {-1,1,0,0};
    static int[] dirX = { 0, 0, -1, 1 };
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int solution;

    static class state {
        int y;
        int x;
        int time;

        state(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    
    public static void firebfs() {
        int size = fire.size();
        while (size > 0) {
            
            int[] pos = fire.poll();

            for (int i = 0; i < 4; i++) {
                int tempy = pos[0] + dirY[i];
                int tempx = pos[1] + dirX[i];
                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && map[tempy][tempx] == '.' && !visited[tempy][tempx]) {
                    fire.offer(new int[] { tempy, tempx });
                    map[tempy][tempx] = 'F';
                    visited[tempy][tempx] = true;
                }
            }
            
            size--;

        }
    }
    
    public static void sanggunbfs() {
        //사이즈 측정
        int size = sanggun.size();


        if (size == 0) {
            flag = false;
            return;
        }

        //현재 큐 사이즈가 다 돌때까지만 실행.

        while (size > 0) {
            state pos = sanggun.poll();

            if ((pos.y == 0 || pos.y == map.length - 1) || (pos.x == 0 || pos.x == map[0].length - 1)) {
                solution = pos.time + 1;
                flag = false;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];
                if (tempy >= 0 && tempy < map.length && tempx >= 0 && tempx < map[0].length && map[tempy][tempx] == '.' && !visited[tempy][tempx]) {
                    sanggun.offer(new state(tempy, tempx, pos.time + 1));
                    visited[tempy][tempx] = true;
                }
            }
            size--;

        }

    }

    

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        map = new char[H][W];
        visited = new boolean[H][W];
        fire = new LinkedList<>();      //불위치
        sanggun = new LinkedList<>();   //상근이
        solution = Integer.MAX_VALUE;   //최소이동값.
        flag = true;            //최종 결과 


        for (int i = 0; i < map.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '#') {
                    visited[i][j] = true;
                    continue;
                }
                if (map[i][j] == 'F') {
                    visited[i][j] = true;
                    fire.offer(new int[] { i, j });
                    continue;
                }

                if (map[i][j] == 'J') {
                    sanggun.offer(new state(i, j, 0));
                    map[i][j] = '.';
                    continue;
                }

            }
        }

        while (flag) {
            firebfs();
            sanggunbfs();
        }
        


        if (solution == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(solution);
        }
    
    }
}

