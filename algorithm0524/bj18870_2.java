package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj18870_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i =0; i< numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = numbers.clone();
        Arrays.sort(temp);
        int count =0 ;
        for(int i=0; i< temp.length; i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i], count++);
            }
        }
        // System.out.println(map.toString());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<temp.length; i++){
            sb.append(map.get(numbers[i])).append(" ");
        }

        System.out.println(sb);
    }
}
