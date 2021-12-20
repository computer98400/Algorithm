package algorithm1219;

import java.util.Scanner;

public class bj2443 {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();


        for (int i = N; i > 0; i--) {
            for (int j = 0; j <N-i; j++) {
                System.out.print(" ");
            }
            for (int j = 2 * i - 1; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
            
        }
        

    }
}
