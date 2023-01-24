package algorithm0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17404 {

    static class node {
        int color;
        int hap;

        public node(int color, int hap) {
            this.color = color;
            this.hap = hap;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] solution = new int[N+2][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        solution[0][0] = 0;
        solution[0][1] = 0;
        solution[0][2] = 0;
        solution[1][0] = map[0][0];
        solution[1][1] = map[0][1];
        solution[1][2] = map[0][2];


        for (int i = 2; i < N; i++) {
            if(i)
        }



    }
}
