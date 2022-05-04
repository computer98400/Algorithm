package algorithm0428;

import java.util.ArrayList;
import java.util.Stack;

public class psbracket {
    public static String solution(String s) {
        if (s.length() == 0) {
            return "";
        }
        int a = 0;
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int start = 0;
        int end = 0;
        int correct = 0;
        ArrayList<Integer> test = new ArrayList<>();
        while (a < s.length()) {
            if (stack.size() == 0) {
                if (s.charAt(a) == ')') {
                    flag = false;
                }
                stack.push(s.charAt(a));
            } else {
                if (stack.peek() == s.charAt(a)) {
                    stack.push(s.charAt(a));
                } else {
                    stack.pop();
                }
            }
            if (stack.size() == 0) {
                flag = true;
                test.add(a + 1);
            }
            System.out.println(test.toString());
            a++;
        }

        if (test.size() != 0) {

            if (test.get(0) != 0) {

                for (int i = 0; i < test.size() - 1; i++) {

                    test(s.substring(test.get(i), test.get(i + 1)));

                }

            }

        }

        return s;

    }
    
    
    public static void test(String s) {
        System.out.println(s);
    }

    
    
    public static void main(String[] args) {
        solution("()))((()");

    }
}
