package algorithm0102;

import java.util.Scanner;

public class bj1924 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        

        int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int days = 0;

        x -= 1;

        if (x != 0) {
            for (int i = 0; i < x; i++) {
                days += months[i];
            }
        }
        days += y;
        //System.out.println(days);
        days %= 7;
        //System.out.println(days);

        switch (days) {
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            case 0:
                System.out.println("SUN");
                break;
        }


    }
}
