package algorithm1219;

import java.util.Scanner;

public class bj2442 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= N; i++) {

            for (int j = N-i; j >0; j--) {
                System.out.print(" ");
            }

            for (int j = i * 2 - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
