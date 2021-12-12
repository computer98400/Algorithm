package algorithm1212;

import java.util.Arrays;
import java.util.Scanner;

public class bj1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[R][C];
        int N = 0;
        int M = 0;
        int[] M2 = new int[C];
        int[] N2 = new int[R];

        for (int i = 0; i < map.length; i++) {
            String temp = sc.nextLine();
            if (temp.contains("X")) {
                R--;
                N2[i]++;
            }
            for (int j = 0; j < map[0].length; j++) {
                if (temp.charAt(j) == 'X') {
                    M2[j]++;
                }
            }
        }
        //System.out.println(Arrays.toString(N2)+ " " + Arrays.toString(M2));
        for (int i = 0; i < M2.length; i++) {
            if (M2[i] == 0) {
                M++;
            }
        }
       // System.out.println(R + " " + M);
        System.out.println(Math.max(R, M));
    }
}
