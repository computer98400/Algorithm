package algorithm1223;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class node2 {
    int time;
    int location;
    int[] record;

    
    node2(int time, int location, int[] record) {

        this.time = time;
        this.location = location;
        this.record = record;
        this.record[time] = location;
    }
}


public class bj13913 {
    
    static void bfs(int N, int K) {
        Queue<node2> que = new LinkedList<>();

        que.offer(new node2(0,N,new int[100]));

        while (!que.isEmpty()) {
            node2 pos = que.poll();

            if (pos.location == K) {
                System.out.println("끝");
                for (int i = 0; i < pos.time; i++) {
                    System.out.println(pos.record[i]);
                }
                return;
            }

            for (int i = 0; i < 3; i++) {
                int tempX = 0;
                if (i == 0) {
                    tempX = pos.location + 1;
                }
                if (i == 1) {
                    tempX = pos.location - 1;
                }
                if (i == 2) {
                    tempX = pos.location * 2;
                }

                if (tempX > 100000 || tempX < 0) {
                    continue;
                }
                que.offer(new node2(pos.time + 1, tempX, pos.record));
                
            }
        }
    }



    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bfs(5, 17);
        


    }
}
