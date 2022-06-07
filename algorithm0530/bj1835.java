package algorithm0530;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj1835 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        Deque<Integer> test = new LinkedList<>();

        test.addLast(N);

        for (int i = N - 1; i > 0; i--) {
            //넣고 뒤에껄 앞으로 옮기면 됨.
            test.addLast(i);
            for (int j = i + 1; j > 0; j--) {
                int temp = test.pollLast();
                test.addFirst(temp);
            }

        }
        StringBuilder sb = new StringBuilder();
        while(!test.isEmpty()){
            sb.append(test.poll()).append(" ");
        }
        System.out.println(sb.toString());
        
    }
}
