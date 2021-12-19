package algorithm1219;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        double[] numbers = new double[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        int n = 0;
    //    System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            n += numbers[i];
        }

        System.out.println(n % 10);
    }
}
