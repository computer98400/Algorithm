package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1325 {
    static class graph {
        int V;
        ArrayList<ArrayList<Integer>> g;
        
        graph(int V) {
            this.V = V+1;
            this.g = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i <= this.V; i++) {
                this.g.add(new ArrayList<Integer>());
            }

        }

        void addEdge(int start, int end) {
            this.g.get(start).add(end);
            //this.g.get(end).add(start);
        }

        ArrayList<Integer> getVertex(int start) {
            return this.g.get(start);
        }

    }

    static boolean[] visited;
    static graph real;

    static void bfs(int start) {
        Queue<ArrayList<Integer>> que = new LinkedList<>();
        que.offer(real.getVertex(start));
        visited[start] = true;
        // System.out.println(real.getVertex(start).toString());
        while (!que.isEmpty()) {
            ArrayList<Integer> pos = que.poll();

            for (int i : pos) {
                if (!visited[i]) {
                    que.offer(real.getVertex(i));
                    visited[i] = true;
                    result[i]++;
                    max = Math.max(result[i], max); 
                }
            }
        }
    }

    static int max = 0;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        real = new graph(V);
        visited = new boolean[V + 1];
        result = new int[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            real.addEdge(start, end);
        }
        // for (int i = 0; i < real.V; i++) {
        //     System.out.println(real.getVertex(i).toString());
        // }
        for (int i = 1; i <= V; i++) {
            bfs(i);
            visited = new boolean[V + 1];
        }
        // System.out.println(max);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
