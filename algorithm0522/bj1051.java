package Algorithm.algorithm0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj1051 {
    public static int N;
    public static int M;
    public static int[][] map;
    public static int max =0;

    //입력값으로 받은 사이즈
    public static int test(int size){
        for(int i =0;i<= N-size; i++){
            for(int j =0; j<= M-size; j++){
                if( map[i][j] == map[i+size-1][j+size-1] && map[i][j] == map[i][j+size-1] && map[i+size-1][j] == map[i+size-1][j+size-1]){
                    return size;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i =0; i< N; i++){
            String temp = br.readLine();
            for(int j=0; j< M; j++){
                map[i][j] = (int)temp.charAt(j)-'0';
            }
        }

        int min = Math.min(N,M);
        for(int i=min; i >0;  i--){
            if(i == 1) {
                System.out.println(i);
                break;
            }

            if(test(i) != 0){
                System.out.println(i*i);
                break;
            }

        }



    }
}
