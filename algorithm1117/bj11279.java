package algorithm1117;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<Long> test = new PriorityQueue<>(Collections.reverseOrder());
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            long temp = sc.nextLong();
            if (temp == 0) {
                if (test.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(test.poll());
                }
            } else {
                test.add(temp);
            }
        }

        sc.close();
    }
}
