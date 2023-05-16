import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14002 {
  static class node {
    int last;
    ArrayList<Integer> numbers = new ArrayList<>();

    node(int last, ArrayList<Integer> numbers) {
      this.last = last;
      this.numbers = numbers;
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(br.readLine());

    node[][] dp = new node[size + 2][size + 1];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] number = new int[size];
    for (int i = 0; i < size; i++) {
      number[i] = Integer.parseInt(st.nextToken());
    }

    for (int h = 0; h < dp.length; h++) {
      for (int w = 0; w < dp[0].length; w++) {
        if (dp[h][w] == null) {
          dp[h][w] = new node(0, new ArrayList<Integer>());
        }
      }
    }
    for (int i = 0; i < size; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(number[i]);
      dp[1][i + 1] = new node(number[i], temp);
    }

    for (int j = 1; j < dp[0].length; j++) {
      if (dp[1][j - 1].last == 0) {
        continue;
      }

      if (dp[1][j - 1].last < number[j - 1]) {
        ArrayList<Integer> temp = dp[2][j - 1].numbers;
        temp.add(number[j - 1]);
        dp[2][j] = new node(number[j - 1], temp);
      }

      if (dp[1][j - 1].numbers.size() + 1 < dp[2][j - 1].numbers.size()) {
        dp[2][j] = dp[2][j - 1];
      }

    }
    for (int i = 2; i < dp.length; i++) {
    }

    for (int h = 0; h < dp.length; h++) {
      for (int w = 0; w < dp[0].length; w++) {
        if (dp[h][w] != null) {
          System.out.print(dp[h][w].last + dp[h][w].numbers.toString() + " ");
        }
      }
      System.out.println();
    }
    System.out.println("=======================");

    // for (int i = 0; i < dp.length; i++) {
    // for (int j = 1; j < dp[0].length; j++) {
    // if(dp[i][j].numbers)
    // }
    // }

    // 간단하게 생각해보자.
    // 하나의 값이 존재할때 해당 값을 포함하는지 안하는지만 확인하면됨.
    // 포함된다는 의미는 해당 값이 이전값보다 작은경우 확인하게됨.
    // 이전값의 위치값만 저장하면됨.
    // h의 값은 포함된 갯수
    // w의 값은 해당 값.
  }
}