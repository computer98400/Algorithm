package algorithm1212;

import java.util.Scanner;

public class bj1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] apa = new int[27];
        for (int i = 0; i < N; i++) {
            String test = sc.nextLine();
            apa[test.charAt(0) - 'a']++;
        }
        String test2 = "";
        for (int i = 0; i < apa.length; i++) {
            if (apa[i] >= 5) {
                test2 += (char) (i + 97);
            }
        }
        if (test2.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(test2);
        }

    }
}
