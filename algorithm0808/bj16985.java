package algorithm0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj16985{
    public static int[][] floor;
    public static void combi(int count, int[] numbers,boolean[] visited){
        if(count == 5){
            test(numbers);
            mapvisited = new boolean[5][5][5];
            return;
        }

        for(int i=0; i<4; i++){
            if(visited[i]) continue;

            numbers[count] = i;
            combi(count+1,numbers,visited);
        }

    }

    public static int[] dirX = {0,0,0,0, 1, -1};
    public static int[] dirY = {0,0,1,-1, 0, 0};
    public static int[] dirZ = {1,-1,0,0, 0, 0};

    public static boolean[][][] mapvisited;
    public static int[][][] maze;
    public static int solution = Integer.MAX_VALUE;

    public static void bfs(){
        Queue<int[]> que= new LinkedList<>();
        que.offer(new int[]{0,0,0,0});
        mapvisited[0][0][0]= true;

        while(!que.isEmpty()){
            int[] temp = que.poll();

            if(temp[0] == 4 && temp[1] == 4 && temp[2] == 4){
                solution = Math.min(temp[3], solution);
                return;
            }


            for(int i=0; i<6; i++){
                int tempx = temp[0] + dirX[i];
                int tempy = temp[1] + dirY[i];
                int tempz = temp[2] + dirZ[i];


                if(tempx >= 0 && tempx < 5 &&tempy >= 0 && tempy < 5 && tempz >= 0 && tempz < 5 && maze[tempx][tempy][tempz] == 1 && !mapvisited[tempx][tempy][tempz]){
                    que.offer(new int[]{tempx,tempy,tempz, temp[3]+1});
                    mapvisited[tempx][tempy][tempz] = true;
                }
            }
        }

    }


    public static void test(int[] dir){
        int k =0;

        for(int count=0;count<dir.length;count++){
            if(dir[count] ==0){
                for(int i=0; i<5; i++){
                    for(int j=0; j< 5; j++){
                        maze[count][i][j] = floor[count][k++];
                        if(maze[count][i][j] == 0){
                            mapvisited[count][i][j] = true;
                        }
                    }
                }
            }else if(dir[count] == 1){
                for(int i=0; i<5; i++){
                    for(int j=4; j>=0; j--){
                         maze[count][j][i] = floor[count][k++];
                         if(maze[count][j][i] == 0){
                            mapvisited[count][j][i] = true;
                        }
                    }
                }
            }else if(dir[count] == 2){
                for(int i=4; i>=0; i--){
                    for(int j=4; j>=0; j--){
                        maze[count][i][j] = floor[count][k++];
                        if(maze[count][i][j] == 0){
                            mapvisited[count][i][j] = true;
                        }
                    }
                }
            }else if(dir[count] == 3){
                for(int i=4; i>=0; i--){
                    for(int j=0; j<5; j++){
                        maze[count][j][i] = floor[count][k++];
                        if(maze[count][j][i] == 0){
                            mapvisited[count][j][i] = true;
                        }
                    }
                }
    
            }
            k = 0;
        }



        if(maze[4][4][4] == 0|| maze[0][0][0] == 0 ){
            
            return;
        }
        bfs();
    }


    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];
        mapvisited = new boolean[5][5][5];
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        floor = new int[5][25];
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<25; i++){
            temp.append(br.readLine()).append(" ");
        }
        StringTokenizer st = new StringTokenizer(temp.toString()," ");

        for(int i =0;i<5; i++){
            for(int j=0; j<25;j++){
                floor[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, new int[5], new boolean[5]);

        if(solution == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            
            System.out.println(solution);
        }
    }
}
