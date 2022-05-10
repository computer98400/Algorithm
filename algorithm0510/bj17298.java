package algorithm0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj17298 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        int start = 0;
        while (st.hasMoreTokens()) {
            numbers[start] = Integer.parseInt(st.nextToken());
            start++;
        }
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() &&numbers[stack.peek()] < numbers[i]){
                    numbers[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        System.out.println(stack.toString());
        
        System.out.println(Arrays.toString(numbers));

    }
}
