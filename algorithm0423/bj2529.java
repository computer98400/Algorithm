package algorithm0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bj2529 {
    public static String[] boo;
    public static ArrayList<String> test;
    public static boolean check(int[] arr){
        for(int i =1; i< arr.length; i++){
            if(boo[i-1].equals("<")){
                if(arr[i-1] > arr[i]){
                    return false;
                }
            }else {
                if(arr[i-1] < arr[i]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void combi(int count, int N, int[] arr, boolean[] select){
        if(count == N){
            if(check(arr)){
                StringBuilder sb = new StringBuilder();

                for(int i =0; i< arr.length; i++){
                    sb.append(arr[i]);    
                }
                test.add(sb.toString());
            }
            return;
        }

        for(int i=0; i<10; i++){
            if(select[i] == true) continue;
            arr[count] = i;
            select[i] = true;
            combi(count+1, N, arr,select);
            select[i] =false;
        }


    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        test = new ArrayList<>();
        boo = br.readLine().split(" ");

        combi(0,N+1, new int[N+1], new boolean[10]);
        System.out.println(test.get(test.size()-1));
        System.out.println(test.get(0));
    }
}
