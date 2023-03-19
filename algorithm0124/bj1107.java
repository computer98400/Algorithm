package algorithm0124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1107 {
  public static boolean[] canPress;
  public static int numberSize;
  public static int number;
  public static int solution = 999999;
  public static void combi(int idx, int[] numbers) {
    if (idx == numberSize+1) {
      String temp = "";
      for (int i = 0; i < numbers.length; i++) {
        temp += Integer.toString(numbers[i]);
      }
      solution = Math.min(calculation(Integer.parseInt(temp))+numberSize,solution);
      return;
    }

    for (int i = 0; i < 10; i++) {
      if (canPress[i])
        continue;

      numbers[idx] = i;
      combi(idx + 1, numbers);
    }

  }

  public static StringBuilder sb = new StringBuilder();


  public static int calculation(int input) {
    return Math.abs(number - input);
  }


  public static void main(String[] args) throws IOException {
    canPress = new boolean[10];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String temp = br.readLine();
    numberSize = temp.length();
    number = Integer.parseInt(temp);
    


    
    int cantpress = Integer.parseInt(br.readLine());
    if (cantpress != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < cantpress; j++) {
        canPress[Integer.parseInt(st.nextToken())] = true;
      }
    }
    if (number == 100) {
      System.out.println(0);
      return;
    }
    

    combi(0, new int[numberSize+1]);

    if (Math.abs(100 - number) < solution) {
      System.out.println(Math.abs(100 - number));
    } else {
      System.out.println(solution);
    }   
  }
}
