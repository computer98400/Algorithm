package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj5800 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i< N; i++){
            String[] temp = br.readLine().split(" ");

            int[] numbers = new int[Integer.parseInt(temp[0])];
            for(int j=0; j< numbers.length; j++){
                numbers[j] = Integer.parseInt(temp[j+1]);
            }
            
            Arrays.sort(numbers);
            int gap =0;
            for(int k=1; k< numbers.length;k++){
                int check = numbers[k]-numbers[k-1];
                gap = Math.max(check, gap);
            }

            System.out.println("Class "+(i+1));
            System.out.println("Max "+numbers[numbers.length-1]+", Min "+numbers[0]+", Largest gap "+gap);
        }


    }
}
