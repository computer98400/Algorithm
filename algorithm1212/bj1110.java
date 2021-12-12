package algorithm1212;

import java.util.Scanner;

public class bj1110 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int origin = N;
        boolean flag = true;
        int X = 0;
        int Y = 0;
        int temp = 0;
        int count = 0;
        while (flag) {
            //System.out.println("check");
            X = N / 10;
            Y = N % 10;
            
            temp = (X + Y) % 10;
            count++;
            //System.out.println(Y * 10 + temp);
            if (Y * 10 + temp == origin) {
                flag = false;
                System.out.println(count);
            }
            N = Y * 10 + temp;
        }

    }
}
