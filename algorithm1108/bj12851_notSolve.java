package algorithm1108;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj12851_notSolve {

    public static int[] Arr = new int[200001];
    static int Min = Integer.MAX_VALUE;
    static int count = 0;

    public static void test(int start, int end) {
        Queue<Integer> test = new LinkedList<>();

        test.offer(start);
        Arr[start] = 1;

        while (!test.isEmpty()) {
            int temp = test.poll();

            // +1, -1, *2 시작위치부터 세가지 경우
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
                    Min = Math.min(Min, Arr[temp]) + 1;
                    count++;
                    continue;
                }
                // 문제의 부분 //////////////////////////////
                if (step >= 0 && step < Arr.length && Arr[step] == 0) {
                    test.offer(step);
                    Arr[step] = Arr[temp] + 1;
                }
                /////////////////////////////////////////////
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        if (start == end) {
            System.out.println(0);
            System.out.println(1);

        } else {
            test(start, end);

            System.out.println(Min);
            System.out.println(count);
        }

    }

}