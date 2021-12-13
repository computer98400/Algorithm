package algorithm1213;
import java.util.Arrays;
import java.util.Scanner;

public class bj1259 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // while (true) {
        //     String temp = sc.nextLine();
        //     if (temp.equals("0")) {
        //         break;
        //     }
        //     int front = 0;
        //     int back = temp.length()-1;
        // //    System.out.println(temp.length() / 2);
        //     int count = 0;
        //     while (front <= back) {
        //         if (temp.charAt(front) == temp.charAt(back)) {
        //             count++;
        //         }
        //         front++;
        //         back--;
        //     }
        //     if (count >= temp.length() / 2)
        //     {
        //         System.out.println("yes");
        //     } else {
        //         System.out.println("no");
        //         }
        //  //   System.out.println("===========================");

        // }
        while (true) {
            int[] test = new int[6];

            String temp = sc.nextLine();
            if (temp.equals("0")) {
                break;
            }
            int end = temp.length();
            for (int i = 0; i < temp.length(); i++) {
                test[i] = temp.charAt(i) - '0';
            }
            boolean flag = true;
            for (int i = 0; i < end; i++) {
                if (test[i] == test[end - i - 1]) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

          //  System.out.println(Arrays.toString(test));
        }
    }
}
