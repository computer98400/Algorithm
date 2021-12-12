package algorithm1212;

import java.util.Scanner;

public class bj1526 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String temp;
        int size;
        int count;
        while (N > 3) {
            temp = Integer.toString(N);
            size = temp.length();
            count = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) - '0' == 4 || temp.charAt(i) - '0' == 7) {
                    count++;
                }
            }
            if (count == size) {
                System.out.println(N);
                break;
            }
            N--;
        }
        


    }
}
