package Algorithm.algorithm1226;

import java.util.HashMap;
import java.util.Scanner;

public class bj1620 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<Integer, String> hash2 = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            hash.put(temp, i+1);
            hash2.put(i+1, temp);
        }
        for (int i = 0; i < M; i++) {
            String temp = sc.nextLine();
            if(temp.charAt(0)-'0' >= 0 && temp.charAt(0)-'0' < 10){
                System.out.println(hash2.get(Integer.parseInt(temp)));
            }else{
                System.out.println(hash.get(temp));
            }
        }

    }
}
