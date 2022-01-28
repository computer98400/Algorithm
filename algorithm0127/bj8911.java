package algorithm0127;

import java.util.Arrays;
import java.util.Scanner;

public class bj8911 {
    
    static int direction;
    static int[] dirY = {1,0,-1,0};
    static int[] dirX = {0,1,0,-1};
    static int[] tutle = new int[2];
    
    static void forward() {
        tutle[0] += dirY[direction];
        tutle[1] += dirX[direction];
    }
    
    static void back() {
        
        tutle[0] -= dirY[direction];
        tutle[1] -= dirX[direction];
    }

    static void turn(char temp) {
        if (temp == 'L') {
            if (direction == 0) {
                direction = 3;
            } else {
                direction--;
            }
        } else if (temp == 'R') {
            direction += 1;
            direction %= 4;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String orders = sc.nextLine();
            int maxY = 0;
            int minY = 0;
            int maxX = 0;
            int minX = 0;
            for (int j = 0; j < orders.length(); j++) {
                if (orders.charAt(j) == 'F') {
                    forward();
                }else if(orders.charAt(j)=='B'){
                    back();
                } else {
                    turn(orders.charAt(j));
                    //System.out.println(direction);
                }
                maxY = Math.max(maxY, tutle[0]);
                minY = Math.min(minY, tutle[0]);
                maxX = Math.max(maxX, tutle[1]);
                minX = Math.min(minX, tutle[1]);
             //   System.out.println(Arrays.toString(tutle));

            }
           // System.out.println(maxY+" "+minY+" "+maxX+" "+minX);
         //   System.out.println(Math.abs(maxY - minY) +" "+ Math.abs(maxX - minX));
            System.out.println(Math.abs(maxY - minY) * Math.abs(maxX - minX));
            tutle = new int[2];
            direction = 0;
        }


    }
}
