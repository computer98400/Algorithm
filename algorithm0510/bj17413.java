package algorithm0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj17413 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int idx = 0;
        boolean tag = false;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (idx < temp.length()) {
            if (tag) {
                while (temp.charAt(idx) != '>') {
                    sb.append(temp.charAt(idx));
                    idx++;
                }
                sb.append(temp.charAt(idx));
                tag = false;
            } else {
                if (temp.charAt(idx) == '<') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    tag = true;
                    continue;
                }

                if (temp.charAt(idx) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(temp.charAt(idx));
                    idx++;
                    continue;
                }

                stack.push(temp.charAt(idx));


            }
            idx++;
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);


    }
}
