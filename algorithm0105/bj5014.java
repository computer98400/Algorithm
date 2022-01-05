package algorithm0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5014 {
    public static int F, S, G, U, D;
    public static int[] map;
    static class store {
        int stair;
        int time;

        store(int stair, int time) {
            this.stair = stair;
            this.time = time;
        }

    }

    public static void bfs(int s) {
        Queue<store> que = new LinkedList<>();
        que.offer(new store(s, 1));
        map[s] = 1;
        while (!que.isEmpty()) {
            store pos = que.poll();
            if (pos.stair == G) {
                System.out.println(pos.time-1);
                return;
            }

            if (pos.stair - D > 0 && map[pos.stair - D] == 0) {
                que.offer(new store(pos.stair - D, pos.time + 1));
                map[pos.stair - D] = pos.time + 1;
            }

            if (pos.stair + U <= F && map[pos.stair + U] == 0) {
                que.offer(new store(pos.stair + U, pos.time + 1));
                map[pos.stair + U] = pos.time + 1;
            }
            
        }
        
        System.out.println("use the stairs");

        return;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        map = new int[F + 1];
        
        bfs(S);
    }
}
