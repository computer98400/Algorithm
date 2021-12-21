package algorithm1221;

import java.util.Arrays;
import java.util.Scanner;

public class bj2798 {
    public static int cut =3;
    public static int M;
    public static int show;
    public static int show2;
    public static int[] origin;
    public static void combi(int idx,int count, int[] numbers) {
        if (count == cut) {
           // System.out.println(Arrays.toString(numbers));
            int temp = 0;
            for (int i = 0; i < cut; i++) {
                temp += numbers[i];
            }

            if (temp <= M)show2 = Math.max(temp, show2);
            return;
        }


        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi(i + 1, count + 1, numbers);
        }

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        M = sc.nextInt();
        origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = sc.nextInt();
        }
        combi(0, 0, new int[N]);
        System.out.println(show2);
    }
}
