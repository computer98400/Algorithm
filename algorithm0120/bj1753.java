package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1753 {
    static class node implements Comparable<node> {
        int E;
        int value;

        
        node(int E, int value) {
            this.E = E;
            this.value = value;
        }


        @Override
        public String toString() {
            return "node [E=" + E + ", value=" + value + "]";
        }


        @Override
        public int compareTo(node o1) {
            if (this.value < o1.value) {
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
                this.g.add(new ArrayList<node>());
            }
        }

        void addVertex(int start, int end, int value) {
            this.g.get(start).add(new node(end, value));
        }

        ArrayList<node> getVertex(int start) {
            return this.g.get(start);
        }
    }

    static void bfs(int startNode) {
        PriorityQueue<node> que = new PriorityQueue<>();
        que.offer(new node(startNode,0));
        daikstra[startNode] = 0;

        while (!que.isEmpty()) {
            node pos = que.poll();
            for (node temp : g.getVertex(pos.E)) {
                if (daikstra[pos.E] + temp.value < daikstra[temp.E]) {
                    que.offer(new node(temp.E,daikstra[pos.E]+temp.value));
                    daikstra[temp.E] = daikstra[pos.E] + temp.value;
                }
            }
        }
    }



    static graph g;
    static boolean[] visited;
    static int[] daikstra;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        g = new graph(V + 1);
        daikstra = new int[V + 1];
        Arrays.fill(daikstra, Integer.MAX_VALUE);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            g.addVertex(start, end, value);
        }
        // for (int i = 0; i <= g.V; i++) {
        //     System.out.println(g.getVertex(i).toString());
        // }
        bfs(startNode);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < daikstra.length; i++) {
            if (daikstra[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(daikstra[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
