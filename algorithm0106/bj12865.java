package algorithm0106;
import java.util.Scanner;

public class bj12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] data = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (data[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - data[i][0]] + data[i][1]);
                }
            }
        }
        
        // for (int j = 0; j < dp.length; j++) {
        //     System.out.println(Arrays.toString(dp[j]));
        // }

        System.out.println(dp[N][K]);
    }
}
