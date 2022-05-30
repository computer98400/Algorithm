package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14888 {

    public static int show;
    public static ArrayList<Integer> origin;
    public static int[] numbers;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void cal(int[] cals){
        int temp = numbers[0];
        for(int i =1; i< numbers.length; i++){
            if(cals[i-1] == 0){
                temp += numbers[i];
            }else if(cals[i-1] == 1){
                temp -= numbers[i];
            }else if(cals[i-1] == 2){
                temp *= numbers[i];
            }else{
                
                temp /= numbers[i];
            }
        }
        max = Math.max(max, temp);
        min = Math.min(min, temp);
    }


    public static void combi( int count, int[] arr, boolean[] visited){
        if(count == show){
            // System.out.println(Arrays.toString(arr));
            cal(arr);
            return;
        }

        for(int i= 0; i < origin.size(); i++){
            if(visited[i]) continue;
            arr[count] = origin.get(i);
            visited[i] = true;
            combi(count+1, arr, visited);
            visited[i] =false;
        }

    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i< N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        origin = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int[] test = new int[4];
        for(int i=0; i< test.length; i++){
            int cal =  Integer.parseInt(st.nextToken());
            for(int j=0; j< cal;  j++){
                origin.add(i);
            }

        }
        show = origin.size();
        combi(0,new int[origin.size()], new boolean[origin.size()]);

        System.out.println(max);
        System.out.println(min);

    }
}
