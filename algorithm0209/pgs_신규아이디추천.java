package algorithm0209;

import java.util.Arrays;
import java.util.Scanner;

public class pgs_신규아이디추천 {
    
    public static String level1(String temp) {
        String check = "";
        for (int a = 0; a < temp.length(); a++) {
            if (temp.charAt(a) >= 65 && temp.charAt(a) <= 90) {
                check += (char)(temp.charAt(a) + 32);
            } else {
                check += temp.charAt(a);
            }
        }
        return check;
    }

    public static String level2(String temp) {
        String check = "";
        for (int i = 0; i < temp.length(); i++) {
            if ((temp.charAt(i) >= 97 && temp.charAt(i) <= 122) || temp.charAt(i) == '-' || temp.charAt(i) == '_'
                    || temp.charAt(i) == '.') {
                check += temp.charAt(i);
            }
        }

        return check;
    }

    public static String level3(String temp) {
        String check = "";
        String[] test = temp.split("temp");

        System.out.println(Arrays.toString(test));
        return check;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String temp = sc.nextLine();
        temp = level1(temp);
        System.out.println(temp);
        temp = level2(temp);
        System.out.println(temp);
        temp = level3(temp);
        System.out.println(temp);


    }


}