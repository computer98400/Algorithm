package algorithm0123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj19238_notSolved {

    
    static int[][] map;
    static int N;
    static taxi start;
    static int fuel;
    static boolean[][] visited;
    static ArrayList<int[]> passenger;
    static ArrayList<int[]> stop;
    static int[] dirY = { -1,1,0,0 };
    static int[] dirX = { 0, 0, -1, 1 };

    static class taxi {
        int y;
        int x;
        int used;
        boolean pickup;
        taxi(int y, int x, int used, boolean pick) {
            this.y = y;
            this.x = x;
            this.used = used;
            this.pickup = pick;
        }
    }

    static int stopPos;
    static int clearT;
    static Queue<taxi> que = new LinkedList<>();

    static void StoP() {

        while (!que.isEmpty()) {
            taxi pos = que.poll();
            if (pos.pickup) {
                map[pos.y][pos.x] = 0;
                que.clear();
                System.out.println("s to p = " + pos.used);
                fuel -= pos.used;
                start = new taxi(pos.y, pos.x, 0, false);
                copyWalls();
                return;
            }

            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];

                if (tempy >= 0 && tempx >= 0 && tempy < N && tempx < N && !visited[tempy][tempx]) {
                    if (map[tempy][tempx] != 0) {
                        que.offer(new taxi(tempy, tempx, pos.used + 1, true));
                        visited[tempy][tempx] = true;
                        stopPos = map[tempy][tempx] - 1;
                        System.out.println(stopPos+" "+tempy+" "+tempx);
                    } else {
                        que.offer(new taxi(tempy, tempx, pos.used + 1, pos.pickup));
                        visited[tempy][tempx] = true;
                    }
                }
            }
        }

    }

    static void PtoD() {
        while (!que.isEmpty()) {
            taxi pos = que.poll();
            if (pos.y == stop.get(stopPos)[0] && pos.x == stop.get(stopPos)[1]) {
                System.out.println(pos.y +" "+pos.x);
                System.out.println("p to d ="+pos.used);
                fuel -= pos.used;
                clearT++;
                que.clear();
                start = new taxi(pos.y, pos.x, 0, false);
                fuel += pos.used * 2;
                System.out.println("add fuel : "+fuel);
                copyWalls();
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tempy = pos.y + dirY[i];
                int tempx = pos.x + dirX[i];
                if (tempy >= 0 && tempx >= 0 && tempy < N && tempx < N && !visited[tempy][tempx]) {
                    que.offer(new taxi(tempy, tempx, pos.used + 1, pos.pickup));
                    visited[tempy][tempx] = true;
                }
            }

        }

    }

    static void newStart(int y, int x) {
        que.clear();
        que.offer(new taxi(y, x, 0, false));
        
    }

    static void copyWalls() {
        visited = new boolean[N][N];
        for (int j = 0; j < walls.size(); j++) {
            visited[walls.get(j)[0]][walls.get(j)[1]] = true;
        }
    }


    static ArrayList<int[]> walls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        clearT = 0;
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        walls = new ArrayList<>();
        stopPos = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    visited[i][j] = true;
                    walls.add(new int[] { i, j });
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        
        start = new taxi(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0,false);
        
        passenger = new ArrayList<>();
        stop = new ArrayList<>();
        
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int passengerY = Integer.parseInt(st.nextToken()) - 1;
            int passengerX = Integer.parseInt(st.nextToken()) - 1;
            int stopY = Integer.parseInt(st.nextToken()) - 1;
            int stopX = Integer.parseInt(st.nextToken()) - 1;
            map[passengerY][passengerX] = i;
            stop.add(new int[] { stopY, stopX });
        }
        // while (fuel > 0) {
            
        //     que.offer(start);
        //     if (clearT == M) {
            //         break;
            //     }
            que.offer(start);
            StoP();
            System.out.println("start to passenger : "+fuel);
            que.offer(start);
            PtoD();
            System.out.println("passenger to Dochak : "+fuel);
            
            que.offer(start);
            StoP();
            System.out.println("start to passenger : "+fuel);
            que.offer(start);
            PtoD();
            System.out.println("passenger to Dochak : "+fuel);
            
            que.offer(start);
            StoP();
            System.out.println("start to passenger : "+fuel);
            que.offer(start);
            PtoD();
            System.out.println("passenger to Dochak : "+fuel);
            
        // }
    }
}
