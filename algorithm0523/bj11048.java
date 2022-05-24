package Algorithm.algorithm0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11048{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] answer = new int[N+1][M+1];

        for(int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j =0; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =1; i< answer.length; i++){
            for(int j=1; j< answer[i].length; j++){
                answer[i][j] = Math.max(Math.max(answer[i-1][j]+map[i-1][j-1],answer[i-1][j-1]+map[i-1][j-1]),answer[i][j-1]+map[i-1][j-1]);
            }
        }
        System.out.println(answer[N][M]);

    }
}