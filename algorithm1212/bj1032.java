package algorithm1212;

import java.util.Scanner;

public class bj1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String ex = sc.nextLine();
        int len = ex.length();
        StringBuilder sb = new StringBuilder();
        if (N == 1) {
            System.out.println(ex);
        } else {
            
        
        for (int i = 0; i < N-1; i++) {
            String temp = sc.nextLine();
            sb.setLength(0);
            for (int j = 0; j < len; j++) {
                if (temp.charAt(j) != ex.charAt(j)) {
                    sb.append("?");
                } else {
                    sb.append(temp.charAt(j));
                }
            }
            ex = sb.toString();
        }
        System.out.println(sb.toString());
    }
    }
}
