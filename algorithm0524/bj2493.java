package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i< N; i++){
            numbers.add(new int []{i,Integer.parseInt(st.nextToken())});
        }
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[N];
        int j = N-1;
        while(j>= 0){
            while(!stack.isEmpty() && numbers.get(j)[1] >= stack.peek()[1]){
                answer[stack.pop()[0]] = numbers.get(j)[0]+1;
            }
            stack.push(numbers.get(j));
            j--;
        }
        while(!stack.isEmpty()){
            answer[stack.pop()[0]] = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< answer.length; i++){
            sb.append(answer[i]).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
