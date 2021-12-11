package Algorithm.algorithmrelay;

import java.util.Scanner;

public class algorithmrelay {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int Tc = sc.nextInt();

        for (int r = 0; r < Tc; r++) {

            System.out.println();

            int n =  (int)Math.round(Math.random()*100%20);
            int m = (int)Math.round(Math.random()*100%(n*n));
 
            System.out.println(n+" "+m);
            
            int[][] map = new int[n][n];
            int[][] idle = new int[m+1][2];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = (int)Math.round(Math.random()*100%9);
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            for (int i = 1; i < idle.length; i++) {

                for (int j = 0; j < 2; j++) {
                    idle[i][j] = (int)Math.round(Math.random()*100%n);
                    System.out.print(idle[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}

//입력값으로 첫줄엔 N과 M을 받는다. 