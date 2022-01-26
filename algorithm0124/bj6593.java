package algorithm0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj6593 {
    static char[][][] map;
    static boolean[][][] visited;
    static int[] start;
    static int[] end;
    static int[] dirY = { 0, 0, 1, -1, 0, 0 };
    static int[] dirX = { 1, -1, 0, 0, 0, 0 };
    static int[] dirL = { 0, 0, 0, 0, 1, -1 };
    static class node {
        int l;
        int r;
        int c;
        int time;

        node(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static void bfs() {
        Queue<node> que = new LinkedList<>();
        que.offer(new node(start[0], start[1], start[2], 0));
        visited[start[0]][start[1]][start[2]] = true;
        //System.out.println("endpoint : "+end[0] + " " + end[1] + " " + end[2]);
        while (!que.isEmpty()) {
            node pos = que.poll();

            if (pos.l == end[0] && pos.r == end[1] && pos.c == end[2]) {
                System.out.println("Escaped in " + pos.time + " minute(s).");
                que.clear();
                return;
            }

            for (int i = 0; i < dirY.length; i++) {
                int    tempL = pos.l + dirL[i];
                int    tempR = pos.r + dirY[i];
                int    tempC = pos.c + dirX[i];
                
                
                if (tempL >= 0 && tempL < L && tempR >= 0 && tempR < R && tempC >= 0
                        && tempC < C && !visited[tempL][tempR][tempC] && map[tempL][tempR][tempC] != '#') {
                    que.offer(new node(tempL, tempR, tempC, pos.time + 1));
                    visited[tempL][tempR][tempC] = true;
                }

            }
        }
        

        System.out.println("Trapped!");
        return;

    }

    static int L;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());

         if (L == 0 && R == 0 && C == 0) {
            break;
        }


        map = new char[L][R][C];
        visited = new boolean[L][R][C];
        start = new int[3];
        end = new int[3];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                String temp = br.readLine();
                for (int j2 = 0; j2 < C; j2++) {
                    map[i][j][j2] = temp.charAt(j2);
                    if (map[i][j][j2] == '#') {
                        visited[i][j][j2] = true;
                    } else if (map[i][j][j2] == 'E') {
                        end[0] = i;
                        end[1] = j;
                        end[2] = j2;
                    } else if(map[i][j][j2] == 'S'){
                        start[0] = i;
                        start[1] = j;
                        start[2] = j2;
                    }
                }
            }
            br.readLine();
        }

        bfs();


        }

    }
}
