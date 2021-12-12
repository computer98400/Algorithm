package algorithm1212;

import java.util.Scanner;

public class bj1453 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] seats = new int[101];
        int count = 0;
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();

            if (seats[temp] == 0) {
                seats[temp]++;
            } else {
                count++;
            }
        }
        System.out.println(count);
    }
}
