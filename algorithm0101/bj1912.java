package algorithm0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1912 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int max = numbers[0];
        int[] dp = new int[N];
        dp[0] =numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            //System.out.println(Arrays.toString(dp));
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
