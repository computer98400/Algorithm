package algorithm1221;

import java.util.Scanner;
import java.util.Stack;

public class bj9012 {

    public static void check(String senten) {
        Stack<Character> test = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < senten.length(); i++) {
            if (senten.charAt(i) == '(') {
                test.push(senten.charAt(i));
            } else {
                if (test.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    test.pop();
                }
            }
        }
        if (flag) {
            if (!test.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        } else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            check(sc.nextLine());
        }


    }
}
