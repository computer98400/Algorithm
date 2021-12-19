package algorithm1219;

import java.util.Scanner;

public class bj8958 {
    
    
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        for (int tc = 0; tc < N; tc++) {
            int count = 0;
            int solution = 0;
            String temp = sc.nextLine();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == 'X') {
                    count = 0;
                } else {
                    count++;
                    solution += count;
                }
            }
            System.out.println(solution);
        }

    }
}
