package Algorithm.algorithm1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj16236_notSolved{
    public static int[][] map;
    public static boolean[][] visited;
    public static int N;
    public static int[] dirX = {0,0,-1,1};
    public static int[] dirY = {-1,1,0,0};
    public static int moves = 0;
    public static int sharkCount = 0;
    public static int sharkSize = 2;

    static class shark{
        int time;
        int[] pos;
        shark(int time,int[] pos){
            this.pos = pos;
            this.time = time;
        }

    }
    public static int fishes;

    public static void eat(int y, int x, int move){
        map[y][x] = 0;
        System.out.println("=======================");
        
        
        moves += move;
        System.out.println("sharkSize : " +sharkSize+" move: "+move+ " moves : "+moves);
        sharkCount++;
        
        if(sharkCount == sharkSize){
            sharkSize++;
            sharkCount =0;
           // System.out.println("grow!! sharkSize : " +sharkSize);

        }

        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(visited[i]));
        // }
        
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static void bfs(int y, int x){
        PriorityQueue<shark> que = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.time,o2.time));
        que.offer(new shark(0,new int[]{y,x}));
        map[y][x] = 0;
        
        while (!que.isEmpty()) {
            shark pos = que.poll();
            for (int i = 0; i < 4; i++) {
                int tempY = pos.pos[0] + dirY[i];
                int tempX = pos.pos[1] + dirX[i];
                //값보다 작은걸 찾아가지만, 
                //만약에 0이 아니라면 count, 
                //숫자라면 size보다 작은것
                //먹었을 경우 visited에 표시.
                //이후
                
                //1. 현재위치에서 물고기들 위치 || 거리 파악
                if(tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map.length && !visited[tempY][tempX] && map[tempY][tempX] <= sharkSize){    
                    //크기가 더 큰건 지나갈수없음.
                    //0이거나 같은건 지나갈수잇음.
                    // 작은 건 먹음.

                    if(map[tempY][tempX] == 0 || map[tempY][tempX] == sharkSize){
                        que.offer(new shark(pos.time+1,new int[]{tempY,tempX}));
                        visited[tempY][tempX] = true;
                    }else{
                        eat(tempY,tempX,pos.time+1);
                        que.clear();
                        que.offer(new shark(0,new int[]{tempY,tempX}));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        int startY =0;
        int startX =0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine()," ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    startY = i;
                    startX = j;
                    map[i][j] = 0;
                }else if(map[i][j] != 0){
                    fishes++;
                }
            }
        }

        bfs(startY, startX);
        System.out.println(moves);
    }

}