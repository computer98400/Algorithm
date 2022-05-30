package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
        String[] temp1 = br.readLine().split(" ");
        int temp2 = Integer.parseInt(br.readLine());
        String[] temp3 = br.readLine().split(" ");

        int A = Integer.parseInt(temp1[0]);
        int B = Integer.parseInt(temp1[1]);

        int[] Aarr = new int[temp2];

        for(int i =0; i< Aarr.length; i++){
            Aarr[i] = Integer.parseInt(temp3[i]);
        }
        int ten = 0;
        for(int i=0; i< Aarr.length; i++){
            for(int j=0; j< Aarr[i];j++){
                ten+= Math.pow(A, temp2-i-1);
            }
        }
        // System.out.println(ten);
        int test = 1;
        while(ten >= Math.pow(B,test)){
            test++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=test-1; i>=0; i--){
            int temp = 0;
            while(ten>=Math.pow(B,i)){
                ten -= Math.pow(B,i);
                temp++;
            }
            sb.append(temp).append(" ");
        }
        System.out.println(sb);
    }
}
