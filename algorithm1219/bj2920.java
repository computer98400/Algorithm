package algorithm1219;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();

        int[] numbers = new int[8];
        StringTokenizer st = new StringTokenizer(temp, " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int count = 1;
        int downCount = 8;
        int ascending = 0;
        int descending = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (count == numbers[i]) {
                ascending++;
          //      System.out.print("test : " + count + " ");
            } else if (numbers[i] == downCount) {
                descending++;
        //        System.out.print("test : " + downCount + " ");
            }
            count++;
            downCount--;
        }
        if (ascending == 8) {
            System.out.println("ascending");
            
        } else if (descending == 8) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

    }
}
