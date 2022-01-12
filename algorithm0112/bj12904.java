package algorithm0112;

import java.util.Scanner;

public class bj12904 {
    

    public static String cal1(String temp) {
        return temp.substring(0,temp.length()-1);
    }

    public static String cal2(String temp) {
        StringBuffer sb = new StringBuffer(temp.substring(0,temp.length()-1));
        return sb.reverse().toString();
    }
    
    public static String check(String temp) {
        if (temp.charAt(temp.length() - 1) == 'A') {
            return cal1(temp);
        } else {
            return cal2(temp);
        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        while (a.length() != b.length()) {
            b = check(b);
        }
        if (a.equals(b)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
}
