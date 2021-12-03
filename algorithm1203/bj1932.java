package Algorithm.algorithm1203;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * bj1932
 */
public class bj1932 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[N][N];
        StringTokenizer st;
        
        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(sc.nextLine()," ");
            for (int j = 0; j < arr.length; j++) {
                if(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        //botton-up

        //top-down
        int max = Integer.MIN_VALUE;
        if(arr.length == 1){
            System.out.println(arr[0][0]);
        } else {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if(j==0){
                        arr[i][j] = arr[i][j]+ arr[i-1][j];
                    }else if(j == i){
                        arr[i][j] = arr[i][j]+ arr[i-1][j-1];
                    }else{
                        arr[i][j] = arr[i][j] + Math.max(arr[i-1][j], arr[i-1][j-1]);
                    }
                    max = Math.max(max, arr[i][j]);
                }
            }
            System.out.println(max);
        }
    }

}