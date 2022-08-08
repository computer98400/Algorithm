package algorithm0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bj16985{
    public static int[] floor1;
    public static int[] floor2;
    public static int[] floor3;
    public static int[] floor4;
    public static int[] floor5;
    public static void combi(int count, int[] numbers,boolean[] visited){
        if(count == 4){
            System.out.println(Arrays.toString(numbers));
                test(0,numbers[0],floor1);
                test(1,numbers[1],floor2);
                test(2,numbers[2],floor3);
                test(3,numbers[3],floor4);
                test(4,numbers[4],floor5);

            return;
        }

        for(int i=0; i<4; i++){
            if(visited[i]) continue;

            numbers[count] = i;
            combi(count+1,numbers,visited);
        }

    }

    public static int[] dirX = {0,0,0,0, 1, 1};
    public static int[] dirY = {0,0,1,1, 0, 0};
    public static int[] dirZ = {1,1,0,0, 0, 0};

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
                System.out.println(temp[3]);
                return;
            }


            for(int i=0; i<6; i++){
                int tempx = temp[0] + dirX[i];
                int tempy = temp[1] + dirY[i];
                int tempz = temp[2] + dirZ[i];


                if(tempx >= 0 && tempx < maze.length &&tempy >= 0 && tempy < maze.length && tempz >= 0 && tempz < maze.length && maze[tempx][tempy][tempz] == 0 && !mapvisited[tempx][tempy][tempz]){
                    que.offer(new int[]{tempx,tempy,tempz, temp[3]+1});
                    mapvisited[tempx][tempy][tempz] = true;
                }
            }
        }

    }


    public static void test(int floor, int dir, int[] map){
        int k =0;
        if(dir ==0){
            for(int i=0; i<5; i++){
                for(int j=0; j< 5; j++){
                    maze[floor][i][j] = map[k++];
                }
            }
        }else if(dir == 1){
            for(int i=0; i<5; i++){
                for(int j=4; j>=0; j--){
                    // System.out.println("i :"+i+" j : "+j+" K : "+(k++));
                     maze[floor][j][i] = map[k++];
                }
            }
        }else if(dir == 2){
            for(int i=4; i>=0; i--){
                for(int j=4; j>=0; j--){
                    maze[floor][i][j] = map[k++];
                }
            }
        }else if(dir == 3){
            for(int i=4; i>=0; i--){
                for(int j=0; j<5; j++){
                     maze[floor][j][i] = map[k++];
                }
            }

        }


    }


    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        floor1 = new int[]{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        String[] n = br.readLine().split(" ");


        combi(0, new int[4], new boolean[4]);

        for(int i=0; i< 5; i++){
            System.out.println(Arrays.deepToString(maze[i]));
        }

    }
}
