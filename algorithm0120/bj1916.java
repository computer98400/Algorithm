package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1916 {
    
    static class node implements Comparable<node>{
        int E;
        int value;

        node(int E, int value) {
            this.E = E;
            this.value = value;
        }

        @Override
        public int compareTo(node o) {
            if (this.value < o.value) {
                return -1;
            }
            return 1;
        }
    }

    static class graph {
        int V;
        ArrayList<ArrayList<node>> g;

        graph(int V) {
            this.V = V;
            this.g = new ArrayList<ArrayList<node>>();
            for (int i = 0; i <= V; i++) {
                g.add(new ArrayList<node>());
            }
        }

        void addVertex(int start, int end, int value) {
            this.g.get(start).add(new node(end, value));
        }

        ArrayList<node> getVertex(int check) {
            return this.g.get(check);
        }
    }

    static int[] daikstra;
    static boolean[] visited;
    static graph g;

    static void bfs(int start, int end) {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.offer(new node(start, 0));
        daikstra[start] = 0;

        while (!que.isEmpty()) {
            node pos = que.poll();
            if (!visited[pos.E]) {
                
                visited[pos.E] = true;
                
                
                for (node temp : g.getVertex(pos.E)) {
                    if (!visited[temp.E] && daikstra[temp.E] > daikstra[pos.E] + temp.value) {
                        daikstra[temp.E] = daikstra[pos.E] + temp.value;
                        que.offer(new node(temp.E, daikstra[pos.E] + temp.value));
                    }
                }
            }
        }
        System.out.println(daikstra[end]);

    }


    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        daikstra = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(daikstra, Integer.MAX_VALUE);
        g = new graph(V + 1);
        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            g.addVertex(start, end, value);
        }

        st = new StringTokenizer(br.readLine(), " ");

        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
    
        bfs(startNode, endNode);
    }
}
