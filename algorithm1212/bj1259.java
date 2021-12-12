package algorithm1212;

import java.util.Scanner;

public class bj1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String temp = sc.nextLine();
            if (temp.equals("0")) {
                break;
            }
            int begin = 0;
            int end = temp.length() - 1;
            
            System.out.println(temp.charAt(begin) + "  " + temp.charAt(end));
            
        }



    }
}
