package algorithm1213;

import java.util.Arrays;
import java.util.Scanner;

public class bj1340 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String temp = sc.nextLine();
        //int years = sc.nextInt();
        sc.close();
        
        String[] dates = temp.split(" ");
        
      //  System.out.println(Arrays.toString(dates));
        
        int[] normalY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] yunY =    { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] Months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        

        int year = Integer.parseInt(dates[2]);
        int month = 0;
        int day = Integer.parseInt(dates[1].substring(0,dates[1].length()-1));
        String[] timeTemp = dates[3].split(":");
        int time = (Integer.parseInt(timeTemp[0]) * 60) + Integer.parseInt(timeTemp[1]);
        for (int i = 0; i < Months.length; i++) {
            if (dates[0].equals(Months[i])) {
                month = i;
                break;
            }
        }
        boolean yun = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            yun = true;
        }

        int monthCheck = 0;
        for (int i = 0; i < month; i++) {
            if (yun) {
                monthCheck += yunY[i];
            } else {
                monthCheck += normalY[i];
            }
        }
        double ttt = ((monthCheck+day-1) * 24 * 60) + time;
        double yuntemp = 366 * 24 * 60;
        double normaltemp = 365 * 24 * 60;
        if (yun) {
         //   System.out.println("yun check");
            System.out.println(100*ttt/yuntemp);
        } else {    
          //  System.out.println("normal check");
            System.out.println(100*ttt/normaltemp);
        }
        
    }
}
