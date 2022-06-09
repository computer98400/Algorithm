package algorithm0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek()=='(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        System.out.println(stack.size());
    }
}
