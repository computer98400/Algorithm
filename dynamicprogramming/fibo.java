package dynamicprogramming;

import java.util.Arrays;

public class fibo {
    
    public static int[] fibos;
    public static int[] fibos2;


    //top-down
    public static int cal(int N) {
        if (N <= 2) {
            return 1;
        }
        if (fibos[N] == 0) {
            fibos[N] = cal(N - 1) + cal(N - 2);
        }
        return fibos[N];
    }

    //bottom-up
    public static int cal2(int N) {
        fibos2[0] = 0;
        fibos2[1] = 1;

        for (int i = 2; i <= N; i++) {
            fibos2[i] = fibos2[i - 1] + fibos2[i - 2];
        }
        return fibos2[N];

    }


    public static void main(String[] args) {
        
        fibos = new int[5];
        fibos2 = new int[6];

        cal(4);
        cal2(5);
        System.out.println(Arrays.toString(fibos));
        System.out.println(Arrays.toString(fibos2));

    }
}
