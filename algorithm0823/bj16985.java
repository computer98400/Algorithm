package algorithm0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16985 {
    
    public static int[] rotation1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    public static int[] rotation2 = {20,15,10,5,0,21,16,11,6,1,22,17,12,7,2,23,18,13,8,3,24,19,14,9,4};
    public static int[] rotation3 = {24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    public static int[] rotation4 = {4,9,14,19,24,3,8,13,18,23,2,7,12,17,22,1,6,11,16,21,0,5,10,15,20};
    //층 순서 순열
    public static int[][] floors = {{0,1,2,3,4},{0,1,2,4,3},{0,1,3,2,4},{0,1,3,4,2},{0,1,4,2,3},{0,1,4,3,2},{0,2,1,3,4},{0,2,1,4,3},{0,2,3,1,4},{0,2,3,4,1},{0,2,4,1,3},{0,2,4,3,1},{0,3,1,2,4},{0,3,1,4,2},{0,3,2,1,4},{0,3,2,4,1},{0,3,4,1,2},{0,3,4,2,1},{0,4,1,2,3},{0,4,1,3,2},{0,4,2,1,3},{0,4,2,3,1},{0,4,3,1,2},{0,4,3,2,1},{1,0,2,3,4},{1,0,2,4,3},{1,0,3,2,4},{1,0,3,4,2},{1,0,4,2,3},{1,0,4,3,2},{1,2,0,3,4},{1,2,0,4,3},{1,2,3,0,4},{1,2,3,4,0},{1,2,4,0,3},{1,2,4,3,0},{1,3,0,2,4},{1,3,0,4,2},{1,3,2,0,4},{1,3,2,4,0},{1,3,4,0,2},{1,3,4,2,0},{1,4,0,2,3},{1,4,0,3,2},{1,4,2,0,3},{1,4,2,3,0},{1,4,3,0,2},{1,4,3,2,0},{2,0,1,3,4},{2,0,1,4,3},{2,0,3,1,4},{2,0,3,4,1},{2,0,4,1,3},{2,0,4,3,1},{2,1,0,3,4},{2,1,0,4,3},{2,1,3,0,4},{2,1,3,4,0},{2,1,4,0,3},{2,1,4,3,0},{2,3,0,1,4},{2,3,0,4,1},{2,3,1,0,4},{2,3,1,4,0},{2,3,4,0,1},{2,3,4,1,0},{2,4,0,1,3},{2,4,0,3,1},{2,4,1,0,3},{2,4,1,3,0},{2,4,3,0,1},{2,4,3,1,0},{3,0,1,2,4},{3,0,1,4,2},{3,0,2,1,4},{3,0,2,4,1},{3,0,4,1,2},{3,0,4,2,1},{3,1,0,2,4},{3,1,0,4,2},{3,1,2,0,4},{3,1,2,4,0},{3,1,4,0,2},{3,1,4,2,0},{3,2,0,1,4},{3,2,0,4,1},{3,2,1,0,4},{3,2,1,4,0},{3,2,4,0,1},{3,2,4,1,0},{3,4,0,1,2},{3,4,0,2,1},{3,4,1,0,2},{3,4,1,2,0},{3,4,2,0,1},{3,4,2,1,0},{4,0,1,2,3},{4,0,1,3,2},{4,0,2,1,3},{4,0,2,3,1},{4,0,3,1,2},{4,0,3,2,1},{4,1,0,2,3},{4,1,0,3,2},{4,1,2,0,3},{4,1,2,3,0},{4,1,3,0,2},{4,1,3,2,0},{4,2,0,1,3},{4,2,0,3,1},{4,2,1,0,3},{4,2,1,3,0},{4,2,3,0,1},{4,2,3,1,0},{4,3,0,1,2},{4,3,0,2,1},{4,3,1,0,2},{4,3,1,2,0},{4,3,2,0,1},{4,3,2,1,0}};
    public static boolean[][][] mapvisited;
    public static int[][][] maze;
    public static int[][][] maze2;
    public static StringBuilder sb = new StringBuilder();
    public static int test =0 ;

    public static int[][] origin;
    
    //방향 조합(중복 순열)
    public static void combi(int count, int[] numbers,boolean[] visited){
        if (count == 5) {
            //0 0 0 0 0
            rotation(numbers);
            return;
        }

        for(int i=0; i<4; i++){
            if(visited[i]) continue;

            numbers[count] = i;
            combi(count+1,numbers,visited);
        }

    }

    //각 방향 조합에 따른 maze 채우기
    public static void rotation(int[] dir) {
        for (int i = 0; i < dir.length; i++) {
            if (dir[i] == 0) {
                for (int j = 0; j < 25; j++) {
                    maze[i][j / 5][j % 5] = origin[i][rotation1[j]];
                }
            }
            if (dir[i] == 1) {
                for (int j = 0; j < 25; j++) {
                    maze[i][j / 5][j % 5] = origin[i][rotation2[j]];
                }
            }
            if (dir[i] == 2) {
                for (int j = 0; j < 25; j++) {
                    maze[i][j / 5][j % 5] = origin[i][rotation3[j]];
                }
            }
            if (dir[i] == 3) {
                for (int j = 0; j < 25; j++) {
                    maze[i][j / 5][j % 5] = origin[i][rotation4[j]];
                }
            }
        }
        
        //maze는 방향조합으로 나온 배열

        //maze2는 해당 방향조합으로 층의 순서를 변경해서 넣어줄 배열.


        //maze2는 maze의 복사본임. 위에선 방향에 대한 중복순열이 주어지고, 이후 층에 대한 순열이 필요하기 때문이다.
        for (int z = 0; z < floors.length; z++) {
            
            for (int x = 0; x < floors[z].length; x++) {
                
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        maze2[x][i][j] = maze[floors[z][x]][i][j];
                    }
                }
            }
            //mapvisited = boolean[][][]
            for(int i=0;i<5;i++){
                for(int j=0;j<5; j++){
                    for(int k=0;k<5;k++){
                        if(maze2[i][j][k] == 0){
                            mapvisited[i][j][k] = true;
                        }else{
                            mapvisited[i][j][k] = false;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(dir));
            for(int i=0; i<5; i++){
                System.out.println(Arrays.deepToString(maze[i]));
            }
            System.out.println();
            for(int i=0; i<5; i++){
                System.out.println(Arrays.deepToString(maze2[i]));
            }
            System.out.println();
            if(maze2[0][0][0] == 1 && maze2[4][4][4] == 1){
                bfs(maze2, mapvisited);
            }
        }
    }

    public static int[] dirx = {0,0,0,0,1,-1};
    public static int[] diry = {0,0,1,-1,0,0};
    public static int[] dirz = { 1, -1, 0, 0, 0, 0 };
    
    public static int solution = Integer.MAX_VALUE;

    //탐색
    //토마토 3차원배열
    public static void bfs(int[][][] map, boolean[][][] visited) {
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        
        while(!que.isEmpty()){
            int[] temp = que.poll();

            if(temp[0] == 4 && temp[1] == 4 && temp[2] == 4){
                solution = Math.min(solution, temp[3]);
            }

            for(int i=0; i< 6; i++){
                int tempx = temp[0]+dirx[i];
                int tempy = temp[1]+diry[i];
                int tempz = temp[2]+dirz[i];

                if(tempx >= 0 && tempx < 5 && tempy >= 0 && tempy < 5 &&tempz >= 0 && tempz < 5 && !visited[tempx][tempy][tempz] && map[tempx][tempy][tempz] == 1){
                    que.offer(new int[]{tempx,tempy,tempz,temp[3]+1});
                    visited[tempx][tempy][tempz]= true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];
        maze2 = new int[5][5][5];
        mapvisited = new boolean[5][5][5];
        origin = new int[5][25];        
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            temp.append(br.readLine()).append(" ");
        }
        StringTokenizer st = new StringTokenizer(temp.toString()," ");
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < 25; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combi(0,new int[5],new boolean[5]);
        if(solution == Integer.MAX_VALUE){
            System.out.println(-1);

        }else{
            System.out.println(solution);

        }
    }
}
