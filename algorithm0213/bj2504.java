package algorithm0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class bj2504 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();

        int So = 0;
        int Dae = 0;
        int solution = 0;
        char last = ' ';
        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Character> cal = new ArrayList<>();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(') {
                st.push(temp.charAt(i));
                number.add(2);
            } else if (temp.charAt(i) == '[') {
                st.push(temp.charAt(i));
                number.add(3);
            } else if (temp.charAt(i) == ')') {
                System.out.println(last);
                char temp2 = st.pop();
                if (temp2 == '(') {
                    cal.add('+');
                } else {
                    break;
                }
            } else if (temp.charAt(i) == ']') {
                System.out.println(last);
                char temp2 = st.pop();
                if (temp2 == '[') {
                    System.out.println("check2");
                    last = temp2;
                }
            }
        }
    }
}
