package algorithm0128;

import java.util.Arrays;
import java.util.Scanner;

public class bj18110 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numbers = new int[N];
        int cut = (int) Math.round(N * 0.15);
        int solution = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        System.out.println(cut);
        
        System.out.println("  "+numbers[cut]+" "+numbers[numbers.length-cut-1]);
        for (int i = cut; i < numbers.length - cut; i++) {
            solution += numbers[i];
        }
        System.out.println(2*cut);
        System.out.println(solution/3);


    }
}
