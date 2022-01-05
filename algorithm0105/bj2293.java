package algorithm0105;

import java.util.Arrays;
import java.util.Scanner;

public class bj2293 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N+1][K+1];

        
        for (int i = 1; i < map.length; i++) {
            int temp = sc.nextInt();
            map[i][0] = temp;
        }
        // for (int k = 0; k < map.length; k++) {
        //     System.out.println(Arrays.toString(map[k]));
        // }
        //int count = 0;
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[0].length; j++) {
                int temp = map[i][0];
                if (j < temp) {
                    map[i][j] = map[i - 1][j];
                }
                if (j == temp) {
                    map[i][j] = map[i - 1][j] + 1;
                }
                
                if (j > temp) {
                    map[i][j] = map[i - 1][j] + map[i][j - temp];
                }
                // count++;
                // System.out.println("count : "+count);
                // System.out.println("===========================");
                // for (int k = 0; k < map.length; k++) {
                //     System.out.println(Arrays.toString(map[k]));
                // }

            }
        }
        System.out.println(map[N][K]);
       

    }
}
