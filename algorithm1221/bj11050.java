package algorithm1221;

import java.util.Scanner;

public class bj11050 {

    public static int factorial(int N) {
        if (N == 0)
            return 1;
        return factorial(N - 1)* N;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int K = sc.nextInt();

       // System.out.println(factorial(N));
      //  System.out.println(factorial(N-K)*factorial(K));
  //      System.out.println(factorial(N));

        System.out.println(factorial(N)/(factorial(N-K)*factorial(K)));

    }
}
