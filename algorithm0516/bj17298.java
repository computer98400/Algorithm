import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] numbers = new int[size];
    int[] solution = new int[size];
    Stack<Integer> idx = new Stack<>();

    for (int i = 0; i < size; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < size; i++) {
      if (!idx.isEmpty() && numbers[idx.peek()] < numbers[i]) {
        while (!idx.isEmpty() && numbers[idx.peek()] < numbers[i]) {
          solution[idx.pop()] = numbers[i];
        }
      }
      // 1 2
      idx.push(i);
    }
    while (!idx.isEmpty()) {
      solution[idx.pop()] = -1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < solution.length; i++) {
      sb.append(solution[i]).append(" ");
    }
    System.out.println(sb.toString());
  }
}