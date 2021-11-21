package algorithm1109;

import java.util.Scanner;

public class bj1929 {

    static void sosu(int start, int end) {
        test: for (int i = start; i <= end; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue test;
                }
            }
            System.out.println(i);

        }
    }

    static void test() {
        int a = 9;

        for (int i = 2; i < a; i++) {
            if (a % i == 0)
                break;
            else
                System.out.println(i);
        }
    }

    static boolean[] prime;

    public static void get_prime() {
        // true = 소수아님 , false = 소수
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        prime = new boolean[b + 1];
        // sosu(a, b);
        // test();
        get_prime();

        for (int i = a; i < prime.length; i++) {
            if (!prime[i])
                System.out.println(i);
        }
        sc.close();
    }

}