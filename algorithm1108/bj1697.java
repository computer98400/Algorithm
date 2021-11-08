package algorithm1108;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1697 {

    public static int[] Arr = new int[200001];

    public static void test(int start, int end) {
        Queue<Integer> test = new LinkedList<>();
        if (start == end) {
            System.out.println(0);
            return;
        }
        test.offer(start);
        Arr[start] = 1;
        while (!test.isEmpty()) {
            int temp = test.poll();

            for (int i = 0; i < 3; i++) {
                int step;

                if (i == 0) {
                    step = temp + 1;
                } else if (i == 1) {
                    step = temp - 1;
                } else {
                    step = temp * 2;

                }

                if (step == end) {
                    System.out.println(Arr[temp]);
                    return;
                }
                if (Arr[step] == 0 && step >= 0 && step < Arr.length) {
                    test.offer(step);
                    Arr[step] = Arr[temp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        test(start, end);

    }

}