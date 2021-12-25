package Algorithm.algorithm1225;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj6996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] alpa;
        for (int i = 0; i < N; i++) {
            StringTokenizer st=  new StringTokenizer(sc.nextLine()," ");
            alpa = new int[26];
            
            String first = st.nextToken();
            for (int j = 0; j < first.length(); j++) {
                alpa[first.charAt(j)-'a']++;
            }
            String second = st.nextToken();

            for (int j = 0; j < second.length(); j++) {
                alpa[second.charAt(j)-'a']--;
            }
            boolean flag = true;
            for (int j = 0; j < alpa.length; j++) {
                if(alpa[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(first+" & "+second+" are anagrams.");
            }else{
                System.out.println(first+" & "+second+" are NOT anagrams.");
            }

        }


    }
}
