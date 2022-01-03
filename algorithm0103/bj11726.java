package algorithm0103;

import java.util.Scanner;

public class bj11726 {

    //public static int[] dp2;

    public static int fibo(int N) {
        
        if (N == 0) {
            return 1;
        } else if (N == 1) {
            return 2;
        }
        return (fibo(N - 1) + fibo(N - 2)) % 10007;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        //int[] dp = new int[N];
        // dp2 = new int[N];
        // if (N == 1) {
        //     System.out.println(1);
        // } else if (N == 2) {
        //     System.out.println(2);
        // } else {
        //     dp[0] = 1;
        //     dp[1] = 2;
        //     for (int i = 2; i < N; i++) {
        //         dp[i] =( dp[i - 1] + dp[i - 2] )% 10007;
        //     }
        //     System.out.println(dp[N - 1]);
        // }
        System.out.println(fibo(N-1));
    }
}
