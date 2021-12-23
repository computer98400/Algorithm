package algorithm1223;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj11170 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = min; j <= max; j++) {
                String temp = Integer.toString(j);
                for (int k = 0; k < temp.length(); k++) {
                    if (temp.charAt(k) == '0') {
                        count++;
                    }
                }
            }
            System.out.println(count);
            
        }



    }
}
