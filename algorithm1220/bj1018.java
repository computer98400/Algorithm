package algorithm1220;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1018 {
    public static boolean[][] map;

    static int check(int x, int y) {
        //System.out.println(x + " " + y);
        boolean show = map[x][y];
        int count = 0;
        
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != show) {
                    count++;
                }
                show = !show;
            }
            show = !show;
        }
//        System.out.println(Math.min(count,64-count));
       return Math.min(count,64-count);
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String st = sc.nextLine();
            for (int j = 0; j < M; j++) {
                if (st.charAt(j) == 'W') {
                    map[i][j] = true;
                }
            }
        }
        // for (int i = 0; i < map.length; i++) {
        //     System.out.println(Arrays.toString(map[i]));
        // }
        int check = Integer.MAX_VALUE;
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                check = Math.min(check,check(i, j));
            }
        }
        System.out.println(check);


    }
}
