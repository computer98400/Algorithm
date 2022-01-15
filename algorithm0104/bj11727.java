package algorithm0104;

import java.util.Arrays;
import java.util.Scanner;

public class bj11727 {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        if (N > 2) {
            dp[1] = 1;
            dp[2] = 3;
            for (int i = 3; i < dp.length; i++) {

                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

            }
            System.out.println(dp[N]);
        } else {
            if (N == 1) {
                System.out.println(1);
            } else {
                System.out.println(3);
            }
        }
    }

}