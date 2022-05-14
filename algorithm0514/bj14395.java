package algorithm0514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//처음 도달한 값이
public class bj14395 {
    public static int t;

    public static HashSet<Long> visited = new HashSet<>(); 
    static class nums {
        Long i;
        String total;

        nums(Long i, String total) {
            this.i = i;
            this.total = total;
        }
        @Override
        public String toString() {
            return Long.toString(this.i)+" "+ this.total;
        }
    }


    public static void bfs(int s) {
        Queue<nums> que = new LinkedList<>();
        que.offer(new nums(Long.valueOf(s), ""));
        
        if (s == t) {
            System.out.println(0);
            return;
        }
        if (t == 1) {
            System.out.println("/");
            return;
        }

        while (!que.isEmpty()) {
            nums temp = que.poll();
            if (temp.i == t) {
                System.out.println(temp.total);
                return;
            }


            if (temp.i != 0) {
                if (!visited.contains(temp.i * temp.i) && temp.i*temp.i <= Math.pow(10,9) ) {
                    que.offer(new nums(Long.valueOf(temp.i * temp.i), temp.total + "*"));
                    visited.add(Long.valueOf(temp.i * temp.i));
                }
                if (!visited.contains((temp.i + temp.i)) && temp.i + temp.i <= Math.pow(10, 9)) {
                    que.offer(new nums(Long.valueOf(temp.i + temp.i), temp.total + "+"));
                    visited.add(Long.valueOf(temp.i + temp.i));
                }
                if (!visited.contains(temp.i / temp.i)) {
                    que.offer(new nums(Long.valueOf(temp.i / temp.i), temp.total + "/"));
                    visited.add(Long.valueOf(temp.i / temp.i));
                }
            }
        }
        System.out.println(-1);
        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        // System.out.println((int)Math.pow(10,9));
        bfs(s);


    }



}
