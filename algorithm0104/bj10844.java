package algorithm0104;

import java.util.Arrays;
import java.util.Scanner;

public class bj10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        
        long[][] dp = new long[(int) (N + 1)][10];

        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = 1L;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int j2 = 0; j2 <= j; j2++) {
                    dp[i][j] += dp[i - 1][j2];
                    dp[i][j] %= 1000000000;
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }\
        long solution = 0;
        for (int i = 0; i < 10; i++) {
            solution += dp[(int) N][i];
        }
        System.out.println(solution%1000000000);
    }
}
