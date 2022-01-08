package algorithm0108;

import java.util.Scanner;

public class bj11005 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        String a = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 65 && a.charAt(i) <= 90) || (a.charAt(i) >= 97 && a.charAt(i) <= 122)) {
                if (a.charAt(i) >= 65 && a.charAt(i) <= 90) {
                    sb.append((char) ((((a.charAt(i) - 65)+13) % 26) + 65));
                } else if (a.charAt(i) >= 97 && a.charAt(i) <= 122) {
                    sb.append((char) ((((a.charAt(i) - 97)+13) % 26) + 97));
                }
            } else {
                sb.append(a.charAt(i));
            }
        }
        System.out.println(sb);
        //A B C D E F G H I J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
        //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25


    }
}
