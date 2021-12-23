package algorithm1223;

import java.util.Scanner;

public class bj1769 {

    public static String change(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }

        return Integer.toString(sum);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        String temp = sc.nextLine();
        int count = 0;
        
        while (temp.length() != 1) {
            temp = change(temp);
            count++;
        }
        if (Integer.parseInt(temp) == 3 || Integer.parseInt(temp) == 6 || Integer.parseInt(temp) == 9) {
            System.out.println(count + "\nYES");
        } else {
            System.out.println(count + "\nNO"); 
        }
        
        
        // if (temp.length() == 1) {
        //     if (Integer.parseInt(temp) % 3 == 0) {
        //         System.out.println(count + "\n" + "Yes");
        //     } else {
        //         System.out.println(count + "\n" + "No");
        //     }
        // } else {
        //     while (true) {
        //         count++;
        //         int check = 0;
        //         for (int i = 0; i < temp.length(); i++) {
        //             check += temp.charAt(i) - '0';
        //         }
        //         System.out.println(check);
        //         if (check < 10) {
        //             if (check == 3 || check == 6 || check == 9) {
        //                 System.out.println(count + "\n" + "Yes");
        //             } else {
        //                 System.out.println(count + "\n" + "No");
        //             }
        //             break;
        //         } else {
        //             temp = Integer.toString(check);
        //         }
                
        //     }
            
        // }  
            
        }
    }
    