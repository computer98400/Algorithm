package Algorithm.algorithm0524;

import java.util.Arrays;

public class bj4673 {
    public static void main(String[] args) {
        
        int[] numbers = new int[10001];
        numbers[0] = 1;
        for(int i=0; i<10000; i++){
            String temp = String.format("%04d", i);
            int total = i;
            for(int j=0; j< temp.length();j++){
                total+= temp.charAt(j)-'0';
            }
            if(total <= 10000){
                numbers[total] = 1;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< numbers.length; i++){
            if(numbers[i] == 0){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
