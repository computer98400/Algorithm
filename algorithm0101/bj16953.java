package algorithm0101;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16953 {


    public static void bfs(int A, int N) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        int solution = 0;
        while (!que.isEmpty()) {
            solution++;
            int temp = que.poll();

            if (temp == A) {
                System.out.println(solution);
                return;
            }

            if (temp < A) {
                System.out.println(-1);
                return;
            }

            if (temp % 10 == 1) {
                que.offer(temp/10);
            }else if (temp % 2 == 0) {
                que.offer(temp / 2);
            } else {
                System.out.println(-1);
                return;
            }
        }   
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();

        bfs(A,B);
       // System.out.println(B / 10);


    }   
}
