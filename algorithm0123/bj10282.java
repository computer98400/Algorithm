package algorithm0123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj10282 {
    static int[] daikstra;
    static boolean[] visited;

    static class node2 implements Comparable<node2> {
        int E;
        int value;

        node2(int E, int value) {
            this.E = E;
            this.value = value;
        }

        @Override
        public int compareTo(node2 o) {
            
            return this.value - o.value;
        }

    }

    static class graph {
        int V;
        ArrayList<ArrayList<node2>> g;

        graph(int V) {
            this.V = V;
            this.g = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                this.g.add(new ArrayList<node2>());
            }
        }

        void addVertex(int start, int end, int value) {
            this.g.get(end).add(new node2(start, value));
        }

        ArrayList<node2> getVertex(int start) {
            return this.g.get(start);
        }
    }

    static graph test;
    static void bfs(int start) {
        PriorityQueue<node2> que = new PriorityQueue<>();

        que.offer(new node2(start, 0));
        daikstra[start] = 0;
        while (!que.isEmpty()) {
            node2 pos = que.poll();

            if (!visited[pos.E]) {
                visited[pos.E] = true;
                for (node2 temp : test.getVertex(pos.E)) {
                    if (daikstra[pos.E] + temp.value < daikstra[temp.E]) {
                        que.offer(new node2(temp.E, daikstra[pos.E] + temp.value));
                        daikstra[temp.E] = daikstra[pos.E] + temp.value;
                    }
                }
            }
        }
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int Tc = Integer.parseInt(br.readLine());

        for (int cc = 0; cc < Tc; cc++) {
            
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        daikstra = new int[N + 1];
        Arrays.fill(daikstra, Integer.MAX_VALUE);
        visited = new boolean[N+1];
        test = new graph(N + 1);
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            test.addVertex(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken()));            
        }
        bfs(start);
        int temp = 0;
        int count = 0;
        for (int i = 0; i < daikstra.length; i++) {
            if (daikstra[i] != Integer.MAX_VALUE) {
                count++;
                temp = Math.max(daikstra[i], temp);
            }
        }
        System.out.println(count+" "+temp);
    }
    }
}
