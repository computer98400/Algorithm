package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj7568 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][2];
        for(int i =0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp =  new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            map[i] = temp;
        }
        int[] answer = new int[N];
        for(int i =0; i<map.length; i++){
            for(int j=0; j< map.length; j++){
                if(i == j) continue;

                if(map[i][0] < map[j][0] && map[i][1] < map[j][1]){
                    answer[i]++;
                }
            }
            answer[i]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
