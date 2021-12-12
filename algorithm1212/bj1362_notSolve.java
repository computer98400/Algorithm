package algorithm1212;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1362_notSolve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int o = sc.nextInt();
        int w = sc.nextInt();
        sc.nextLine();
        String check;
        int move;
        boolean flag = true;
        boolean liveordie = true;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(sc.nextLine(), " ");
            check = st.nextToken();
            move = Integer.parseInt(st.nextToken());
            if (check == "#" && move == 0) {
                if (!liveordie) {
                    System.out.println("RIP");
                    continue;
                } else if (o / 2 < w && o * 2 > w) {
                    System.out.println(":-)");
                    continue;
                } else {
                    System.out.println(":-(");
                    continue;
                }
            }
            

            

        }


    }
}
