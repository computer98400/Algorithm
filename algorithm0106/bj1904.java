package algorithm0106;

import java.util.Scanner;

public class bj1904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        
        if (N >= 2) {
            int[] number = new int[N + 1];
            number[0] = 0;
            number[1] = 1;
            number[2] = 2;

            for (int i = 3; i < number.length; i++) {
                number[i] = (number[i - 1] + number[i - 2]) % 15746;
            }
            System.out.println(number[N]);
        } else {
            System.out.println(1);
        }
    }
}
