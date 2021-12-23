package algorithm1223;

import java.util.Arrays;
import java.util.Scanner;

public class bj11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();


        int[][] map = new int[N + 1][N + 1];

        map[0][0] = 1;
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (j == 0) {
                    map[i][j] = map[i - 1][j];
                } else if (i == j) {
                    map[i][j] = map[i - 1][j - 1];
                } else {
                    map[i][j] = (map[i - 1][j] + map[i - 1][j - 1]) % 10007;
                }
            }
        }
        // for (int j = 0; j < map.length; j++) {
        //     System.out.println(Arrays.toString(map[j]));
        // }
        System.out.println(map[N][K]);
    }
}
