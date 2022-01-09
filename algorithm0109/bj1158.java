package algorithm0109;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.close();
        Queue<Integer> test = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            test.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (test.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                test.offer(test.poll());
            }
            sb.append(test.poll() + ", ");
        }
        sb.append(test.poll() + ">");
        System.out.println(sb);
    }
}
