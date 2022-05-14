package algorithm0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10844 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[a+1];

        arr[1] = 9;
        arr[2] = 17;
        arr[3] = 31;
        for (int i = 4; i < arr.length; i++) {
            System.out.println(arr[i-1]*2);
            System.out.println(((i - 1) * (i - 2))/2);
            arr[i] = (int)(((arr[i - 1] * 2) - (((i-1)*(i-2))/2))%Math.pow(10,9));
        }
        System.out.println(arr[a]);
    }
}
