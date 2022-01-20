package algorithm0120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class graphTest {
    

    static class graph {
        int V;
        int E;
        ArrayList<ArrayList<Integer>> g;

        graph(int V, int E) {
            this.V = V;
            this.E = E;
            g = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i <= V; i++) {
                g.add(new ArrayList<Integer>());
            }
        }

        //양방향
        void addEdge(int point, int value) {
            this.g.get(point).add(value);
            this.g.get(value).add(point);
        }

        ArrayList<Integer> getVertex(int point) {
            return this.g.get(point);
        }

    }
    
    
    static void bfs() {
        Queue<ArrayList<Integer>> que = new LinkedList<>();

        que.offer(test.getVertex(1));

        while (!que.isEmpty()) {
            ArrayList<Integer> pos = que.poll();

            for (int i : pos) {
                if (!visited[i]) {
                    que.offer(test.getVertex(i));
                    visited[i] = true;
                    System.out.println(Arrays.toString(visited));
                }
            }
        }
    }

    static graph test;
    static boolean[] visited;
    public static void main(String[] args) {
        test = new graph(5, 4);
        visited = new boolean[6];
        test.addEdge(1, 2);
        test.addEdge(2, 5);
        test.addEdge(2, 4);
        test.addEdge(2, 3);
        System.out.println(test.getVertex(2).toString());
        bfs();
    }
}
