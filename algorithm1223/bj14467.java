package algorithm1223;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj14467 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] cows = new int[11];
        Arrays.fill(cows, -1);
        int moving = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int cowN = Integer.parseInt(st.nextToken());
            int cowP = Integer.parseInt(st.nextToken());

            if (cows[cowN] == -1) {
                cows[cowN] = cowP;
            } else {
                if (cows[cowN] == cowP) {
                    continue;
                } else {
                    cows[cowN] = cowP;
                    moving++;
                }
            }
        }
        System.out.println(moving);
    }
}
