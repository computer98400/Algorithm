package algorithm0111;

import java.util.ArrayList;
import java.util.Scanner;

public class bj2576 {
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);
        int sol = 0;
        int test = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                sol += n;
                test = Math.min(n, test);
            }
        }
        System.out.println(sol == 0 ? -1 : sol+"\n"+test);
    }
}
