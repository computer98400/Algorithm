package Algorithm.algorithm1109;

import java.util.Scanner;

public class bj2527 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int p2 = sc.nextInt();
        int q2 = sc.nextInt();
        int[][] map = new int[50000][50000];

        for (int i = x; i < p; i++) {
            for (int j = y; j < q; j++) {
                map[i][j] = 1;
            }
        }
        for (int i = x2; i < p2; i++) {
            for (int j = y2; j < q2; j++) {
                map[i][j] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        //int include = (p - x) * (q - y);
        System.out.println(count);
        sc.close();

    }

}