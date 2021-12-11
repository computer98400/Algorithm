package algorithm1211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj3055 {
    public static int[] dirX = { 0, 0, 1, -1 };
    public static int[] dirY = { 1, -1, 0, 0 };
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] D;
    public static int[] S;
    public static int watercount;
    public static ArrayList<int[]> waters;
    public static int movecount;
    public static boolean[][][] waterMove; 


    //고슴도치가 보는 맵, 물이 이동하는 맵이 다른 것으로 체크가 따로 하게 만든다면?

    public static void water() {
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < waters.size(); i++) {
            que.offer(waters.get(i));
            visited[waters.get(i)[0]][waters.get(i)[1]] = true;
        }
        
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            //물의 움직임 먼저 표현
            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];
                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !waterMove[tempY][tempX][0]) {
                    que.offer(new int[] { tempY, tempX });
                    visited[tempY][tempX] = true;
                    waterMove[tempY][tempX][1] = true;
                    waterMove[tempY][tempX][0] = true;
                }
            }
            //물 이동 체크 완료
            System.out.println("=============start==========");
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            System.out.println("=============end==========");
        }
    
    
    }
    public static void gosum(int y, int x) {
        Queue<int[]> test = new LinkedList<>();
        test.offer(new int[] { y, x });
        while (!test.isEmpty()) {
            int[] pos = test.poll();

            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];

                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !waterMove[tempY][tempX][1]) {
                    if (tempY == D[0] && tempX == D[1]) {
                        System.out.println("도달");
                        return;
                    }
                    System.out.print(tempY + " " + tempX+"    ");
                    test.offer(new int[] { tempY, tempX });
                    visited[tempY][tempX] = true;
                    waterMove[tempY][tempX][1] = true;
                }
            }
            System.out.println();
        }
    }

    public static void bfs2(int y, int x) {
        Queue<int[]> water = new LinkedList<>();
        Queue<int[]> go = new LinkedList<>();

        for (int i = 0; i < waters.size(); i++) {
            water.offer(waters.get(i));
        }
        go.offer(new int[] { y, x });
        while (!water.isEmpty()) {
            int[] flood = water.poll();
            int[] gosum = go.poll();
            if (gosum == null) {
                System.out.println("KAKTUS");
                return;
            }
            for (int i = 0; i < dirX.length; i++) {
                int tempY = flood[0] + dirY[i];
                int tempX = flood[1] + dirX[i];

                if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length
                        && !waterMove[tempY][tempX][0]) {
                    water.offer(new int[] { tempY, tempX });
                    visited[tempY][tempX] = true;
                    waterMove[tempY][tempX][1] = true; //고슴도치 이동방면을 제한하기위해서
                    waterMove[tempY][tempX][0] = true; //물이 이전부분을 탐색하지 못하게
                }
            }

            for (int i = 0; i < dirX.length; i++) {
                int tempY = gosum[0] + dirY[i];
                int tempX = gosum[1] + dirX[i];

                if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length
                        && !waterMove[tempY][tempX][1]) {
                    if (tempY == D[0] && tempX == D[1]) {
                        System.out.println("성공?"+movecount); //맵에 따른 성공값 출력
                        return;
                    }
                    go.offer(new int[] { tempY, tempX });
                    waterMove[tempY][tempX][1] = true; //고슴도치가 왔던길을 안함.
                }
            }
            movecount++;
            


        }



    }
    public static void bfs(int y, int x) {
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> go = new LinkedList<>();

        for (int i = 0; i < waters.size(); i++) {
            que.offer(waters.get(i));
            visited[waters.get(i)[0]][waters.get(i)[1]] = true;
        }
        go.offer(new int[] { y, x });
        
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            int[] move = go.poll();
            if (move == null){
                System.out.println("KAKTUS");
                return;
            }
            //물의 움직임 먼저 표현
            for (int i = 0; i < dirX.length; i++) {
                int tempY = pos[0] + dirY[i];
                int tempX = pos[1] + dirX[i];
                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !visited[tempY][tempX]
                        && map[tempY][tempX] == 1) {
                    que.offer(new int[] { tempY, tempX });
                    visited[tempY][tempX] = true;
                }
            }
            watercount++;
           System.out.println(watercount);
            //물 이동 체크 완료
            System.out.println("=============start==========");
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            System.out.println("=============end==========");
            //고슴도치 이동 체크
            for (int i = 0; i < dirX.length; i++) {
                int tempY = move[0] + dirY[i];
                int tempX = move[1] + dirX[i];
                if (tempY == D[0] && tempX == D[1]) {
                    System.out.println("끝!!!"+movecount);
                    return;
                }
                if (tempY >= 0 && tempX >= 0 && tempY < map.length && tempX < map[0].length && !visited[tempY][tempX]) {
                    go.offer(new int[] { tempY, tempX });
                }
            }
            movecount++;


        }
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        map = new int[R][C];
        visited = new boolean[R][C];
        //0의 경우 물의 시점
        //1의 경우 고슴도치의 시점

        waterMove= new boolean[R][C][2];
        waters = new ArrayList<>();
        String st;
        for (int i = 0; i < R; i++) {
            st = sc.nextLine();
            for (int j = 0; j < C; j++) {
                if (st.charAt(j) == 'D') {
                    D = new int[] { i, j };
                    map[i][j] = 1;
                    waterMove[i][j][0] = true;
                } else if (st.charAt(j) == 'S') {
                    S = new int[] { i, j };
                    waterMove[i][j][1] = true;
                } else if (st.charAt(j) == '*') {
                    waters.add(new int[] { i, j });
                    visited[i][j] = true;
                    waterMove[i][j][1] = true;
                    waterMove[i][j][0] = true;
                } else if (st.charAt(j) == 'X') {
                    visited[i][j] = true;
                    waterMove[i][j][0] = true;
                    waterMove[i][j][1] = true;
                } else if (st.charAt(j) == '.') {
                    map[i][j] = 1;
                }
            }
        }
        
        
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(visited[i]));
        // }
        //bfs(S[0], S[1]);
        //System.out.println(Arrays.toString(D));
        //water();
        //gosum(S[0], S[1]);
        bfs2(S[0], S[1]);
    }   
}
