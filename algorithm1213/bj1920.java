package algorithm1213;

import java.util.Arrays;
import java.util.Scanner;

public class bj1920 {
    public static int[] numbers;
    public static int binary(int searchN) {
     
        int left=0;
        int right = numbers.length - 1;
        int mid = 0;
        
        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] == searchN) {
                return 1;
            }

            if (numbers[mid] < searchN) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;

    }
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);

        numbers = new int[sc.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

       // System.out.println(Arrays.toString(numbers));

        int searchCount = sc.nextInt();
        for (int i = 0; i < searchCount; i++) {
            System.out.println(binary(sc.nextInt()));
        }
    }
}
