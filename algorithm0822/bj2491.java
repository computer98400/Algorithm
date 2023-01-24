package algorithm0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2491 {

    static class node {
        int max;
        int min;

        public node() {
            this.max = 0;
            this.min = 0;
        }
        public node(int x, int y) {
            this.max = x;
            this.min = y;
        }
        @Override
        public String toString() {
            return max+", "+min;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];
        node[] solution = new node[N+1];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }
        solution[0] = new node(1, 1);

        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] <= numbers[i]) {
                if (numbers[i - 1] < numbers[i]) {
                    solution[i] = new node(solution[i - 1].max + 1, 1);
                } else {
                    solution[i] = new node(solution[i - 1].max + 1, solution[i - 1].min + 1);
                }
            }
            if (numbers[i - 1] >= numbers[i]) {
                if (numbers[i - 1] > numbers[i]) {
                    solution[i] = new node(1, solution[i - 1].min + 1);
                } else {
                    solution[i] = new node(solution[i - 1].max + 1, solution[i - 1].min + 1);
                }
            }
            max = Math.max(max, solution[i].max);
            min = Math.max(min, solution[i].min);
        }
        System.out.println(Math.max(max, min));

    }
}