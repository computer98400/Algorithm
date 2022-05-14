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
        int count = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(') {
                test.push(1);
            } else {
                test.pop();
                if (temp.charAt(i - 1) == '(') {
                    count += test.size();
                } else {
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
