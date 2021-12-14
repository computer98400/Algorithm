package algorithm1215;

import java.util.Scanner;

public class bj1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();

        int[] numbers = new int[10];
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '6' || temp.charAt(i) == '9') {
                numbers[6]++;
            } else {
                numbers[temp.charAt(i) - '0']++;
            }
        }
        int count = 0;
        if (numbers[6] % 2 == 1) {
            numbers[6] = numbers[6] / 2 + 1;
        } else {
            numbers[6] /= 2;
        }
        for (int i = 0; i < numbers.length; i++) {
            count = Math.max(numbers[i], count);
        }
        
        System.out.println(count);

    }
}
