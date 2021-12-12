package algorithm1212;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1357 {
    
    public static int Rev(String temp) {
        String a = "";
        for (int i = temp.length()-1; i >=0; i--) {
            a += temp.charAt(i) - '0';
        }
       // System.out.println(a);
        
        return Integer.parseInt(a);   
    }
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        System.out.println(Rev(Integer.toString(Rev(st.nextToken())+Rev(st.nextToken()))));
    }   
}
