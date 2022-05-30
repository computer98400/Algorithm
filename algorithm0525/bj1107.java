package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bj1107 {
    public static int wantsize;
    public static String origin;
    public static int tonum;
    public static int diff;
    public static int diff2;
    public static ArrayList<Integer> nums;
    public static int current;
    public static void combi( int count, int[] arr, boolean[] visited){
        if(count == wantsize){
            // System.out.println(Arrays.toString(arr));
            int temp =0;
            int size = 0;
            for(int i=0;i<arr.length; i++){
                if(arr[i] != 0){
                    size = arr.length-i;
                    break;
                }
            }
            for(int i=0; i< arr.length; i++){
                temp += arr[i]*Math.pow(10, arr.length-i-1);

            }
            diff = Math.min(diff,size+Math.abs(temp-tonum));
            return;
        }

        for(int i=0; i< nums.size(); i++){

            arr[count] = nums.get(i);
            combi( count+1, arr, visited);
        }

    }
    public static void combi2( int count, int[] arr, boolean[] visited){
        if(count == (wantsize-1)){
            // System.out.println(Arrays.toString(arr));
            int temp =0;
            int size = 0;
            for(int i=0;i<arr.length; i++){
                if(arr[i] != 0){
                    size = arr.length-i;
                    break;
                }
            }
            for(int i=0; i< arr.length; i++){
                temp += arr[i]*Math.pow(10, arr.length-i-1);
            }
            diff2 = Math.min(diff2,size+Math.abs(temp-tonum));
            return;
        }

        for(int i=0; i< nums.size(); i++){
            arr[count] = nums.get(i);
            combi2( count+1, arr, visited);
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        origin = br.readLine();
        wantsize = origin.length();
        tonum = Integer.parseInt(origin);
        diff = Integer.MAX_VALUE;
        diff2 = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[10];
        String[] st;

        if(N == 0){
            if(Math.abs(tonum-100) < wantsize){
                System.out.println(Math.abs(tonum-100));
            }else{
                System.out.println(wantsize);
            }
            return;
        }
        st = br.readLine().split(" ");


        
        for(int i=0; i< st.length; i++){
            numbers[Integer.parseInt(st[i])] = 1;
        }
        nums = new ArrayList<>();
        
        for(int i=0; i< numbers.length; i++){
            if(numbers[i] != 1){
                nums.add(i);
            }
        }



        combi(0,new int[wantsize],new boolean[nums.size()]);
        combi2(0,new int[wantsize-1], new boolean[nums.size()]);
        
        diff = Math.min(diff, diff2);

        if(tonum== 100){
            System.out.println(0);
            return;
        }else if(tonum < diff ){
            System.out.println("check!!!!!!!!!!!1");
            System.out.println(tonum+1);
            return;
        }else if(Math.abs(tonum-100) < diff){
            System.out.println(Math.abs(tonum-100));
            return;
        }else{
            System.out.println(diff);
        }



    }
}
