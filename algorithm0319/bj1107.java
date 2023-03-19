import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1107 {
  static StringBuilder sb = new StringBuilder();
  static boolean[] cantPush = new boolean[10];
  static int solution = Integer.MAX_VALUE;
  static int solutionLen = 0;

  static StringBuilder numbertest;
  static int needChannel = 0;
  public static int trans(int[] number) {
    numbertest = new StringBuilder();
    for (int i = 0; i < number.length; i++) {
      numbertest.append(number[i]);
    }
    return Integer.parseInt(numbertest.toString());
  }
  public static void test(int N, int start,int end, int[] numbers) {
  
    if (N == end) {
      if(Math.abs(trans(numbers) - needChannel) < solution){
        solution = Math.abs(trans(numbers) - needChannel);
        solutionLen = end;
      }
      // if (temp != solution) {
      //   sb.append(trans(numbers)).append(" ").append(solution).append('\n');
      // }
      return;
    }


    for (int i = 0; i < 10; i++) {
      if (!cantPush[i])
        continue;
      numbers[N] = i;
      test(N + 1, i + 1, end, numbers);
    }

  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Arrays.fill(cantPush, true);
    String temp = br.readLine();
    needChannel = Integer.parseInt(temp);
    int reach = temp.length();
    String pushCnt = br.readLine();

    if (!pushCnt.equals("0")) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      while (st.hasMoreTokens()) {
        cantPush[Integer.parseInt(st.nextToken())] = false;
      }
    }

    if (needChannel == 100) {
      System.out.println(0);
      return;
    }

    for (int i = 1; i <= reach + 1; i++) {
      test(0, 0, i, new int[i]);
    }
    solution += solutionLen;
    solution = Math.min(solution, Math.abs(100 - needChannel));

    System.out.println(solution);
  }
}
