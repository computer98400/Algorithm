package algorithm0112;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj14395 {
    public static boolean[] visited;
    static class chance {
        int x;
        int count;
        String cal;

        chance(int x,int count, String cal) {
            this.x = x;
            this.count = count;
            this.cal = cal;
        }
    }

    public static void bfs(int start, int end) {
        Queue<chance> que = new LinkedList<>();

        que.offer(new chance(start, 0, ""));
        visited[start] = true;

        while (!que.isEmpty()) {

            chance pos = que.poll();

            if (pos.x == end) {
            
                System.out.println(pos.cal);
                return;
            
            }

            int plus = pos.x + pos.x;
            int minus = pos.x - pos.x;
            int gob = pos.x * pos.x;
            int nanugi = pos.x / pos.x;

            if (gob > 0 && gob <= end && !visited[gob]) {
                que.offer(new chance(gob, pos.count + 1, pos.cal + "*"));
                visited[gob] = true;
            }

            if (plus > 0 && plus <= end && !visited[plus]) {
                que.offer(new chance(plus, pos.count + 1, pos.cal + "+"));
                visited[plus] = true;
            }

            if (minus > 0 && minus <= end && !visited[0]) {
                que.offer(new chance(minus, pos.count + 1, pos.cal + "-"));
                visited[minus] = true;
            }

            if (nanugi > 0 && nanugi <= end && !visited[nanugi]) {
                que.offer(new chance(nanugi, pos.count + 1, pos.cal + "/"));
                visited[nanugi] = true;
            }

        }
        System.out.println(-1);
        return;
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int t = sc.nextInt();
        visited = new boolean[100000001];

        if (s == t) {
            System.out.println(0);
        } else {
            bfs(s, t);
        }
    }
}
