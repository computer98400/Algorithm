package algorithm1223;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj2303 {
    public static int check;
    public static int[] origin;
    public static void combi(int N,int idx, int count, int[] numbers) {
        if (count == N) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += numbers[i];
            }
            check = Math.max(temp % 10, check);
            return;
        }
        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi(N, i + 1, count + 1, numbers);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[] players = new int[N+1];
        for (int i = 1; i < players.length; i++) {
            origin = new int[5];
            check = 0;
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            for (int j = 0; j < origin.length; j++) {
                origin[j] = Integer.parseInt(st.nextToken());
            }
            combi(3, 0, 0, new int[5]);
            players[i] = check;
        }
        int solution = -1;
        int show = -1;
        //System.out.println(Arrays.toString(players));
        for (int i = 0; i < players.length; i++) {
            if (solution <= players[i]) {
                solution = players[i];
                show = i;
            }
        }
        System.out.println(show);
    }
}
