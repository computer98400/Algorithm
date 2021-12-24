package Algorithm.algorithm1224;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16953 {
    public static boolean show;
    public static int solution;

    static class check{
        long N;
        int count;

        check(long N, int count) {
            this.N = N;
            this.count = count;
        }
    }
    public static void bfs(long N, long M) {
        Queue<check> que = new LinkedList<>();
        que.offer(new check(N,1));
        while (!que.isEmpty()) {
            check pos = que.poll();

            if (pos.N == M) {
                show = true;
                solution = pos.count;
                return;
            }
            for (int i = 0; i < 2; i++) {
                long temp = 0;
                if (i == 0) {
                    temp = 2 * pos.N;
                } else {
                    String temp2 = Long.toString(pos.N);
                    temp2 += "1";
                    temp = Integer.parseInt(temp2);
                }
                if (temp > M) {
                    continue;
                } else {
                    que.offer(new check(temp,pos.count+1));
                }
            }
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        bfs(N, M);
        if (show) {
            System.out.println(solution);
        } else {
            System.out.println(-1);
        }
    }
}