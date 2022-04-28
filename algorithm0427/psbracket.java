package algorithm0427;

import java.util.Stack;

public class psbracket {
    
    public static String solution(String s) {
        Stack<Character> stk = new Stack<>();
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (s.charAt(i) == '(') {
                if (stk.peek() == '(') {
                    stk.push('(');
                }
                open++;
            } else {
                
            }

        }
        return "";
    }
    
    public static String step1(String temp) {
        return "";
    }
    

    public static String step2(String temp) {
        return "";
    }

    public static String step3(String temp) {

        return "";
    }

    public static String step4(String temp) {
        
        
        
        return "";
    }
    

    public static void main(String[] args) {
        solution("(()())()");

    }
}