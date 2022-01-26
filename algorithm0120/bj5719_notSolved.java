package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj5719_notSolved {

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
            this.g.get(start).add(new node(end, value,""));
        }
        
        ArrayList<node> getVertex(int check) {
            return this.g.get(check);
        }

        int getDistance(int start, int i) {
            return this.g.get(start).get(i).value;
        }

        void removeVertext(int start, int end) {
            this.g.get(start).remove(end);
        }
    }
    
    static boolean[] visited;
    static boolean[] visited2;
    
    static int[] daikstra;
    
    static graph g;
    
    static void bfs(int S, int E) {
        PriorityQueue<node> que = new PriorityQueue<>();
        
        que.offer(new node(S, 0, ""));
        daikstra[S] = 0;
        while (!que.isEmpty()) {
            node pos = que.poll();
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
        
        //구간합  마지막값 - 현재까지의 합 = 현재부터 마지막까지의 값
        System.out.println(Arrays.toString(daikstra));
    }
    static ArrayList<Integer> test = new ArrayList<Integer>();
    
    //그래프에서 해당 노드의 거리값  A->B가는 값을 탐색하는걸 먼저 확인하고.
    //현재 Daikstra[N] = Daikstra[i] + (daikstra[N] - graph.get(i).거리값);
    static void bfs2(int S,int E) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(E);
        while (!que.isEmpty()) {
            int pos = que.poll();
            for (int temp = 0; temp < daikstra.length; temp++) {
                for (int j = 0; j < 4; j++) {
                    if (daikstra[pos] == daikstra[temp] + g.getDistance(temp,j)) {
                        System.out.println(temp);
                        g.removeVertext(temp, pos);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {


            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            if (V == 0 && E == 0) {
                break;
            }

            daikstra = new int[V];
            visited = new boolean[V + 1];
            visited2 = new boolean[V + 1];
            Arrays.fill(daikstra, Integer.MAX_VALUE);
            g = new graph(V + 1);
            st = new StringTokenizer(br.readLine(), " ");
            
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                g.addVertex(start, end, value);
            }
            bfs(startNode, endNode);
        
            bfs2(startNode, endNode);
        }

    }
}

// 7 9
// 0 6
// 0 1 1
// 0 2 1
// 0 3 2
// 0 4 3
// 1 5 2
// 2 6 4
// 3 6 2
// 4 6 4
// 5 6 1