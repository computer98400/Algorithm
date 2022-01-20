package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj11779 {
    

    static class node implements Comparable<node>{
        int E;
        int value;
        String check;
        node(int E, int value,String check) {
            this.E = E;
            this.value = value;
            this.check = check;
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
                this.g.add(new ArrayList<node>());
            }
        }

        void addVertex(int start, int end, int value) {
            this.g.get(start).add(new node(end, value,Integer.toString(start)));
        }

        ArrayList<node> getVertex(int check) {
            return this.g.get(check);
        }

        void removeEdge(String temp) {
            StringTokenizer st = new StringTokenizer(temp, " ");
            int start = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int N = Integer.parseInt(st.nextToken());
                g.get(start).remove(N);
                start = N;
            }

            for (int i = 0; i < g.size(); i++) {
                System.out.println(g.get(i).toString());
            }
        }
    }

    static boolean[] visited;
    
    static int[] daikstra;

    static graph g;
    static ArrayList<String[]> testS;
    static void bfs(int S, int E) {
        PriorityQueue<node> que = new PriorityQueue<>();
        testS = new ArrayList<>();
        que.offer(new node(S, 0,Integer.toString(S)));
        daikstra[S] = 0;    
        while (!que.isEmpty()) {
            node pos = que.poll();
            if (pos.E == E) {
                testS.add(new String[] { pos.check, Integer.toString(pos.value) });
            }
            if (!visited[pos.E]) {
                visited[pos.E] = true;
                for (node temp : g.getVertex(pos.E)) {
                    if (!visited[temp.E] && daikstra[temp.E] > daikstra[pos.E] + temp.value) {
                        daikstra[temp.E] = daikstra[pos.E] + temp.value;
                        que.offer(new node(temp.E, daikstra[pos.E] + temp.value, pos.check + " " + temp.E));
                    }
                }
            }
        }
        for (String[] temp : testS) {
            if (Integer.parseInt(temp[1]) == daikstra[E]) {
                System.out.println(daikstra[E]);
                String[] test = temp[0].split(" ");
                System.out.println(test.length);
                System.out.println(temp[0]);
                return;
            }

        }
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        daikstra = new int[V+1];
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
        
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());
        bfs(startNode, endNode);
    }
}
