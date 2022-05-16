package algorithm0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj3986 {
    
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            Stack<Character> stack = new Stack<>();
            //같지 않으면 내비두고, 같으면 뽑기.
            for (int j = 0; j < temp.length(); j++) {
                if (stack.isEmpty()) {
                    stack.add(temp.charAt(j));
                } else {
                    if (temp.charAt(j) == stack.peek()) {
                        stack.pop();
                    } else {
                        stack.add(temp.charAt(j));
                    }
                }
            }
            // System.out.println(stack.toString());

            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
