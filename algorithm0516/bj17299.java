import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17299 {
  static class node {
    int count;
    int number;

    node(int a, int b) {
      this.count = a;
      this.number = b;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] numbers = new int[size];
    int[] test = new int[1000001];
    node[] counts = new node[size];
    int[] solution = new int[size];
    Stack<Integer> idx = new Stack<>();

    for (int i = 0; i < size; i++) {
      int temp = Integer.parseInt(st.nextToken());
      numbers[i] = temp;
      test[temp] += 1;
    }
    for (int i = 0; i < size; i++) {
      counts[i] = new node(test[numbers[i]], numbers[i]);
    }
    for (int i = 0; i < size; i++) {
      if (!idx.isEmpty() && counts[idx.peek()].count < counts[i].count) {
        while (!idx.isEmpty() && counts[idx.peek()].count < counts[i].count) {
          solution[idx.pop()] = counts[i].number;
        }
      }
      idx.push(i);
      // 1 2
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