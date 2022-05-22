package Algorithm.algorithm0521;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] numbers = new int[n];

        for(int i =0; i< numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> list = new Stack<>();
        int[] answer = new int[n];        
        for(int i =0; i< numbers.length; i++){
            while(!list.isEmpty() && numbers[list.peek()] < numbers[i]){
                answer[list.peek()] = numbers[i];
                list.pop();
            }
            list.push(i);
        }
        while(!list.isEmpty()){
            answer[list.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i< answer.length; i++){
            sb.append(answer[i]).append(' ');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}
