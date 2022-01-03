package algorithm0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj3055 {
    public static char[][] map;
    public static boolean[][] visited;
    public static Queue<int[]> test;
    public static int[] dirY = { -1, 1, 0, 0 };
    public static int[] dirX = { 0, 0, -1, 1 };
    
    
    //Queue를 통해서 돌릴때 isempty를 사용하지않고 현재 사이즈를 탐색하여 해당 사이즈만을 돌리게 되면 현재 탐색범위를 탐색하고 끝낼수잇다ㅣ
    public static void bfs() {
            int count = test.size();
            while (count > 0) {
                int[] waterpos = test.poll();
                for (int i = 0; i < 4; i++) {
                    int tempY = waterpos[0] + dirY[i];
                    int tempX = waterpos[1] + dirX[i];
                    if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length
                            && map[tempY][tempX] == '.') {
                        test.offer(new int[] { tempY, tempX });
                        map[tempY][tempX] = '*';
                    }
                }
                count--;
            }
    }

    static class go {
        int y;
        int x;
        int di;

        go(int y, int x, int di) {
            this.y = y;
            this.x = x;
            this.di = di;
        }

    }
    public static Queue<go> gosumQue;
    public static go last;
    public static boolean gosum(int a, int b) {
        int count = gosumQue.size();
       // System.out.println("도착 : " + dochakY + " " + dochakX);
        while (count > 0) {
            
            go gosumpos = gosumQue.poll();
            if (gosumpos.y == a && gosumpos.x == b) {
                last = gosumpos;
                gosumQue.clear();
                return true;
            }
            for (int i = 0; i < 4; i++) {
                
                int tempY = gosumpos.y + dirY[i];
                int tempX = gosumpos.x + dirX[i];
                
                if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length && !visited[tempY][tempX] && (map[tempY][tempX] == '.' || map[tempY][tempX] == 'D')) {
                    gosumQue.offer(new go(tempY, tempX, gosumpos.di + 1));
                    visited[tempY][tempX] = true;
                }
            }
            count--;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        test = new LinkedList<>();
        gosumQue = new LinkedList<>();
        int dochakX = 0;
        int dochakY = 0;

        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == '*') {
                    test.offer(new int[] { i, j });
                    visited[i][j] = true;
                } else if (map[i][j] == 'S') {
                    gosumQue.offer(new go(i, j, 0));
                } else if (map[i][j] == 'D') {
                    dochakY = i;
                    dochakX = j;
                } else if (map[i][j] == 'X') {
                    visited[i][j] = true;
                }
            }
        }
        while (true) {
            bfs();
            if (gosum(dochakY,dochakX)) {
                System.out.println(last.di);
                break;
            }
            if (gosumQue.isEmpty()) {
                System.out.println("KAKTUS");
                break;
            }
        }
    }
}
