package algorithm0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj16985 {
    
    public static int[] rotation1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    public static int[] rotation2 = {20,15,10,5,0,21,16,11,6,1,22,17,12,7,2,23,18,13,8,3,24,19,14,9,4};
    public static int[] rotation3 = {24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
    public static int[] rotation4 = {4,9,14,19,24,3,8,13,18,23,2,7,12,17,22,1,6,11,16,21,0,5,10,15,20};
    //층 순서 조합
    public static int[][] floors = {{0,1,2,3,4},{0,1,2,4,3},{0,1,3,2,4},{0,1,3,4,2},{0,1,4,2,3},{0,1,4,3,2},{0,2,1,3,4},{0,2,1,4,3},{0,2,3,1,4},{0,2,3,4,1},{0,2,4,1,3},{0,2,4,3,1},{0,3,1,2,4},{0,3,1,4,2},{0,3,2,1,4},{0,3,2,4,1},{0,3,4,1,2},{0,3,4,2,1},{0,4,1,2,3},{0,4,1,3,2},{0,4,2,1,3},{0,4,2,3,1},{0,4,3,1,2},{0,4,3,2,1},{1,0,2,3,4},{1,0,2,4,3},{1,0,3,2,4},{1,0,3,4,2},{1,0,4,2,3},{1,0,4,3,2},{1,2,0,3,4},{1,2,0,4,3},{1,2,3,0,4},{1,2,3,4,0},{1,2,4,0,3},{1,2,4,3,0},{1,3,0,2,4},{1,3,0,4,2},{1,3,2,0,4},{1,3,2,4,0},{1,3,4,0,2},{1,3,4,2,0},{1,4,0,2,3},{1,4,0,3,2},{1,4,2,0,3},{1,4,2,3,0},{1,4,3,0,2},{1,4,3,2,0},{2,0,1,3,4},{2,0,1,4,3},{2,0,3,1,4},{2,0,3,4,1},{2,0,4,1,3},{2,0,4,3,1},{2,1,0,3,4},{2,1,0,4,3},{2,1,3,0,4},{2,1,3,4,0},{2,1,4,0,3},{2,1,4,3,0},{2,3,0,1,4},{2,3,0,4,1},{2,3,1,0,4},{2,3,1,4,0},{2,3,4,0,1},{2,3,4,1,0},{2,4,0,1,3},{2,4,0,3,1},{2,4,1,0,3},{2,4,1,3,0},{2,4,3,0,1},{2,4,3,1,0},{3,0,1,2,4},{3,0,1,4,2},{3,0,2,1,4},{3,0,2,4,1},{3,0,4,1,2},{3,0,4,2,1},{3,1,0,2,4},{3,1,0,4,2},{3,1,2,0,4},{3,1,2,4,0},{3,1,4,0,2},{3,1,4,2,0},{3,2,0,1,4},{3,2,0,4,1},{3,2,1,0,4},{3,2,1,4,0},{3,2,4,0,1},{3,2,4,1,0},{3,4,0,1,2},{3,4,0,2,1},{3,4,1,0,2},{3,4,1,2,0},{3,4,2,0,1},{3,4,2,1,0},{4,0,1,2,3},{4,0,1,3,2},{4,0,2,1,3},{4,0,2,3,1},{4,0,3,1,2},{4,0,3,2,1},{4,1,0,2,3},{4,1,0,3,2},{4,1,2,0,3},{4,1,2,3,0},{4,1,3,0,2},{4,1,3,2,0},{4,2,0,1,3},{4,2,0,3,1},{4,2,1,0,3},{4,2,1,3,0},{4,2,3,0,1},{4,2,3,1,0},{4,3,0,1,2},{4,3,0,2,1},{4,3,1,0,2},{4,3,1,2,0},{4,3,2,0,1},{4,3,2,1,0}};
    public static boolean[][][] mapvisited;
    public static int[][][] maze;
    public static StringBuilder sb = new StringBuilder();
    public static int test =0 ;

    public static int[][] origin;
    
    //

    
    //방향 조합
    public static void combi(int count, int[] numbers,boolean[] visited){
        if(count == 5){
            
            return;
        }

        for(int i=0; i<4; i++){
            if(visited[i]) continue;

            numbers[count] = i;
            combi(count+1,numbers,visited);
        }

    }

    public static void cal(){
        
    }


    //각 방향 조합에 따른 maze 채우기
    public static void rotation(int[] dir){
        for(int i=0;i<dir.length; i++){
            if(dir[i] == 0){
                for(int j=0;j<25;j++){
                    maze[i][j/5][j%5] = origin[i][rotation1[j]];
                    if(maze[i][j/5][j%5] == 0){
                        mapvisited[i][j/5][j%5] = true;
                    }
                }
            }
            if(dir[i] == 1){
                for(int j=0;j<25;j++){
                    maze[i][j/5][j%5] = origin[i][rotation2[j]];
                    if(maze[i][j/5][j%5] == 0){
                        mapvisited[i][j/5][j%5] = true;
                    }
                }
            }
            if(dir[i] == 2){
                for(int j=0;j<25;j++){
                    maze[i][j/5][j%5] = origin[i][rotation3[j]];
                    if(maze[i][j/5][j%5] == 0){
                        mapvisited[i][j/5][j%5] = true;
                    }
                }
            }
            if(dir[i] == 3){
                for(int j=0;j<25;j++){
                    maze[i][j/5][j%5] = origin[i][rotation4[j]];
                    if(maze[i][j/5][j%5] == 0){
                        mapvisited[i][j/5][j%5] = true;
                    }
                }
            }
        }
    }


    //탐색
    public static void bfs(){


    }


    public static void main(String[] args) throws IOException {
        maze = new int[5][5][5];
        mapvisited = new boolean[5][5][5];
        
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));

        StringBuilder temp = new StringBuilder();
        for(int i=0; i<25; i++){
            temp.append(br.readLine()).append(" ");
        }
        StringTokenizer st = new StringTokenizer(temp.toString()," ");



    }
}
