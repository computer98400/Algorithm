package algorithm0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1935 {
    
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        String temp = br.readLine();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> test = new Stack<>();
        
        for (int i = 0; i < temp.length(); i++) {
            // System.out.println(" 현재 값 : " + temp.charAt(i));
            if (temp.charAt(i) - 'A' >= 0 && temp.charAt(i) - 'A' <= 26) {
                test.add((double) numbers[temp.charAt(i) - 'A']);
            } else {
                Double b = test.pop();
                Double a = test.pop();
                if (temp.charAt(i) == '+') {
                    test.add(a + b);
                } else if (temp.charAt(i) == '-') {
                    test.add(a - b);
                } else if (temp.charAt(i) == '/') {
                    // System.out.println("a: " +a +" b : "+b +" "+a/b);
                    test.add(a / b);
                } else if (temp.charAt(i) == '*') {
                    test.add(a * b);
                }
            }
            // System.out.println(test.toString());
        }
        System.out.println(String.format("%.2f", test.pop()));



    }
    
}