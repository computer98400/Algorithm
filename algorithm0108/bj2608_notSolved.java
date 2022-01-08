package algorithm0108;

import java.util.Arrays;
import java.util.Scanner;

public class bj2608_notSolved {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        int transA = 0;

        char[] arrA = new char[a.length()];
        int[] arrAtrans = new int[a.length()];
        int[] numbers = { 1, 5, 10, 50, 100, 500, 1000 };


        for (int i = 0; i < a.length(); i++) {
            arrA[i] = a.charAt(i);
            if (arrA[i] == 'M') {
                arrAtrans[i] = 1000;
            } else if (arrA[i] == 'D') {
                arrAtrans[i] = 500;
            } else if (arrA[i] == 'C') {
                arrAtrans[i] = 100;
            } else if (arrA[i] == 'L') {
                arrAtrans[i] = 50;
            } else if (arrA[i] == 'X') {
                arrAtrans[i] = 10;
            } else if (arrA[i] == 'V') {
                arrAtrans[i] = 5;
            } else if (arrA[i] == 'I') {
                arrAtrans[i] = 1;
            }
        }
        int temp = 0;
        int count = 1;
        for (int i = 0; i < arrAtrans.length; i++) {
            if (arrAtrans[i - 1] < arrAtrans[i]) {
                count++;
            } else {
                temp += arrAtrans[i] - (count * arrAtrans[i - 1]);
                count = 1;
            }
        }
        
        System.out.println(temp);

        System.out.println(Arrays.toString(arrA));
        System.out.println(Arrays.toString(arrAtrans));
    }
}
