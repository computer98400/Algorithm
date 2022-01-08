package algorithm0107;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj13913 {
    
    static class move {
        int N;
        int time;
        String load;

        move(int N,int time, String load) {
            this.N = N;
            this.time = time;
            this.load = load;
        }
    }
    
    public static boolean[] map;

    public static void bfs(int a, int b) {
        Queue<move> que = new LinkedList<>();

        que.offer(new move(a,0, Integer.toString(a)+" "));
        map[a] = true;

        while (!que.isEmpty()) {
            move temp = que.poll();

            if (temp.N == b) {
                System.out.println(temp.time);
                System.out.println(temp.load);
                return;
            }


            if (temp.N * 2 < map.length && !map[temp.N * 2]) {
                que.offer(new move(temp.N * 2, temp.time + 1, temp.load + Integer.toString(temp.N * 2) + " "));
                map[temp.N * 2] = true;
            }
            
            if (temp.N + 1 < map.length && !map[temp.N + 1]) {
                que.offer(new move(temp.N + 1,temp.time+1, temp.load + Integer.toString(temp.N + 1)+" "));
                map[temp.N +1] = true;
            }
            if (temp.N - 1 >= 0 && !map[temp.N - 1]) {
                que.offer(new move(temp.N - 1, temp.time + 1, temp.load + Integer.toString(temp.N -1)+" "));
                map[temp.N -1] = true;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new boolean[100001];
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        if (a > b) {
            for (int i = a; i >= b; i--) {
                sb.append(i + " ");
            }
            System.out.println((a-b));
            System.out.println(sb);
        } else {
            }
            //bfs(a, b);
    }
}
