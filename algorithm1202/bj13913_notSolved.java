package Algorithm.algorithm1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj13913_notSolved {
    private int[] test = new int[10000];
    private int[] link = new int[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


    }
    

    public void bfs(int start, int end ){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        test[start] = 1;
        test[end] = Integer.MIN_VALUE;

        while(!que.isEmpty()){
            int a = que.poll();
            if(a == end){
                System.out.println(test[a]);
                return;
            }

            
            if(test[a-1] == 0){
                test[a-1] = test[a] +1;
                que.offer(a-1);
            }
            if(test[a*2] == 0){
                test[a*2] = test[a] +1;
                que.offer(a*2);
            }
            if(test[a+1] == 0){
                test[a+1] = test[a] +1;
                que.offer(a+1);
            }

        }

    }



}