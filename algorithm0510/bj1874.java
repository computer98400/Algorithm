package algorithm0510;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class bj1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        int[] num = new int[n];
        for (int i = 0; i < n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            que.add(i);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        //1
        //12
        //123
        //1234
        //123
        //12
        //125
        //1256
        //125
        //1257
        //12578
        //1257
        //125
        //12
        //1
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (idx < n) {
            // System.out.println(stack.toString());
            // if (que.isEmpty()) {
            //     break;
            // }
            if (stack.isEmpty()) {
                // System.out.println("+");
                sb.append("+").append("\n");
                stack.push(que.poll());
                continue;
            }

            if (stack.peek() == num[idx]) {
                sb.append("-").append("\n");
                stack.pop();
                idx++;
                continue;
            }

            if (stack.peek() < num[idx]) {
                sb.append("+").append("\n");
                stack.push(que.poll());
                continue;
            }

            if (stack.peek() > num[idx]) {
                flag = true;
                // stack.push(que.poll());
                // continue;
                break;
            }

        }

        if (flag) {
            System.out.println("No");
        } else {
            System.out.println(sb.toString());
        }
    }
}
