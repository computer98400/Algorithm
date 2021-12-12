package algorithm1212;

import java.util.Scanner;

public class bj1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String test ="";
        for (int i = 0; i < 8; i++) {
            String temp = sc.nextLine();
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j += 2) {
                    if (temp.charAt(j) == 'F') {
                        count++;
                    }
                }
            } else {
                for (int j = 1; j < 8; j += 2) {
                    if (temp.charAt(j) == 'F') {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
