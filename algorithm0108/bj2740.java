package algorithm0108;

import java.util.Arrays;
import java.util.Scanner;

public class bj2740 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int nA = sc.nextInt();
        int mA = sc.nextInt();
        int[][] A = new int[nA][mA];
        for (int i = 0; i < nA; i++) {
            for (int j = 0; j < mA; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int nB = sc.nextInt();
        int mB = sc.nextInt();
        int[][] B = new int[nB][mB];
        
        for (int i = 0; i < nB; i++) {
            for (int j = 0; j < mB; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] solution = new int[nA][mB];

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {

                for (int j2 = 0; j2 < mA; j2++) {
                    solution[i][j] += A[i][j2] * B[j2][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                sb.append(solution[i][j]).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    
    }
}
