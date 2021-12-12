package algorithm1212;

import java.util.Scanner;

public class bj1018not_Solve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            sb.append(temp);
        }
        System.out.println(sb.length());
        System.out.println(sb.toString());

        int white = 0;
        int black = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'W') {
                white++;
            } else {
                black++;
            }
        }
        



        System.out.println(white+" "+black);
    }
}
