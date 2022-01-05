package algorithm0105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        ArrayList<Integer> cards = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            cards.add(i+1);
        }
        System.out.println(cards.toString());

        StringBuilder sb = new StringBuilder();
        while (N != 1) {
            sb.append(cards.remove(0)+" ");
            int temp = cards.remove(0);
            cards.add(temp);
            N--;
        }
        sb.append(cards.remove(0));
        System.out.println(sb);
    }
}
