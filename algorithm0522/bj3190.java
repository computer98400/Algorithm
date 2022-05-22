package Algorithm.algorithm0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj3190 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int[] location  = {0,0};
        int[] dirY = {0,1,0,-1};
        int[] dirX = {1,0,-1,0};
        int current = 0;
        Deque<int[]> test = new LinkedList<>();       
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i< K; i++){
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 999;
        }
        
        int L = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i< L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            String rotation = st.nextToken();

            for(int j =0; j< count; j++){
                location[0] += dirY[current];
                location[1] += dirX[current];
            
                if(map[location[0]][location[1]] == 999){
                    
                }
            }

            if(rotation == "D"){
                current = (current+1)%4;
            }else{
                current = (current-1)%4;
            }
        }


    }
}
