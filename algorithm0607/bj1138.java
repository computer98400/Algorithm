package algorithm0607;

import java.util.ArrayList;
import java.util.Scanner;

public class bj1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            order[i] = sc.nextInt();
        }
        sc.close();

        ArrayList<Integer> test = new ArrayList<>();

        for (int i = order.length - 1; i >= 0; i--) {
            test.add(order[i], (i + 1));
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < test.size(); i++) {
            sb.append(test.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
