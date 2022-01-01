package algorithm0101;

import java.util.Scanner;

public class bj2805 {

    public static int[] lans;
    public static int max;
    public static int min;
    public static void search(long M) {
        while (min < max) {
           // System.out.println(min + " " + max);
            int mid = (max + min) / 2;
            long sum = 0;

            for (int i = 0; i < lans.length; i++) {
                if (lans[i] - mid > 0)
                    sum += (lans[i] - mid);
            }
            if (sum < M) {
                max = mid;
            } else {
                min = mid+1;
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextInt();

        lans = new int[N];

        for (int i = 0; i < N; i++) {
            lans[i] = sc.nextInt();
            max = Math.max(max, lans[i]);
        }
        search(M);
        System.out.println(min-1);
    }
}
