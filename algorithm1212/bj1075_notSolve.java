package algorithm1212;

import java.util.Scanner;

public class bj1075_notSolve {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();
        long b = sc.nextInt();

        System.out.println(a%b);
        System.out.println(a-(a%b));
    }
}
