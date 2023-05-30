
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11052 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int count = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] numbers = new int[count];

    for (int i = 0; i < count; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    // 가로 값은 각 갯수?
    // 세로 값은 ??

    int[] dp = new int[count + 1];
    dp[0] = 0;
    dp[1] = numbers[0];
    dp[2] = Math.max(numbers[0] + numbers[0], numbers[1]);

    for (int i = 2; i < dp.length; i++) {
      dp[i] = Math.max(numbers[i], dp[count - i] + numbers[0]);
    }
    System.out.println(Arrays.toString(dp));
    // asdf
  }
}
