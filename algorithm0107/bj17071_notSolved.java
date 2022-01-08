package algorithm0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17071_notSolved {
    
    public static boolean[] map = new boolean[500001];
    public static Queue<int[]> que = new LinkedList<>();
    public static boolean stop;
    public static int des;
    public static void bfs(int b) {
        int test = que.size();
        //System.out.println(des +" test: "+test);
        while (test-- > 0) {
            int[] temp = que.poll();
            //System.out.println(des + " test : " + temp[0]);
            if (b == temp[0]) {
                System.out.println("==================" + (temp[1]));
                stop = true;
                return;
            }

            if (temp[0] + 1 < map.length) {
                que.offer(new int[] { temp[0] + 1, temp[1] + 1 });
            }

            if (temp[0] - 1 >= 0) {
                que.offer(new int[] { temp[0] - 1, temp[1] + 1 });
            }

            if (temp[0] * 2 < map.length) {
                que.offer(new int[] { temp[0] * 2, temp[1] + 1 });
            }
        }
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        que.offer(new int[] { a, 0 });
        map[a] = true;
        des = b;
        int count = 1;
        while(!stop){
            bfs(des);
            des = b;
            for (int j = 1; j <= count; j++) {
                des += j;
            }
            System.out.println(des+" "+count);
            count++;
            if (count == 5) {
                break;
            }
        }
        
    }
}
