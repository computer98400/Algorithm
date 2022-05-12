package algorithm0512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        Stack<Integer> test = new Stack<>();
        Stack<Integer> cut = new Stack<>(); 
        int count = 0;
        boolean cutflag = false;
        for (int i = 1; i < temp.length(); i++) {
            if (temp.charAt(i) == ')') {
                if (temp.charAt(i - 1) == '(') {
                    if (test.isEmpty()) {
                        cut.push(i);
                    } else {
                        test.pop();
                        cut.push(i);
                    }
                } else {
                    System.out.println(test.pop() + " " + i);
                }
            } else {
                test.push(i);
            }
            // System.out.println(count);
        }
        System.out.println(cut.toString());
    }
}
