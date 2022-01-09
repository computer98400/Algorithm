package algorithm0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class bj11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1)-Math.abs(o2);
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp != 0) {
                pq.offer(temp);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()+"\n");
                } else {
                    sb.append(0+"\n");
                }
            }
        }

        System.out.println(sb);

    }
}
