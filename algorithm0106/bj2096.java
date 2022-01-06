package algorithm0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj2096 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[][] map = new int[N + 1][3];
        int[][] map2 = new int[N + 1][3];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (j == 0)
                    map[i][0] = Math.max(map[i - 1][0], map[i - 1][1]) + arr[i - 1][0];
                if (j == 1)
                    map[i][1] = Math.max(Math.max(map[i - 1][0], map[i - 1][1]), map[i - 1][2]) + arr[i - 1][1];
                if (j == 2)
                    map[i][2] = Math.max(map[i - 1][1], map[i - 1][2]) + arr[i - 1][2];
            }
        }
        
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (j == 0)
                    map2[i][0] = Math.min(map2[i - 1][0], map2[i - 1][1]) + arr[i-1][0];
                if (j == 1)
                    map2[i][1] = Math.min(Math.min(map2[i - 1][0], map2[i - 1][1]), map2[i - 1][2]) + arr[i-1][1];
                if (j == 2)
                    map2[i][2] = Math.min(map2[i - 1][1], map2[i - 1][2]) + arr[i-1][2];
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(map[map.length - 1][i], max);
            min = Math.min(map2[map2.length - 1][i], min);
        }

        System.out.println(max+" "+min);

    }
}
