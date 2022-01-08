package DataStructure;

import java.util.ArrayList;

public class mkgraph22 {
       
    public static void main(String[] args) {
        
        graphTest test = new graphTest(5);

        test.put(1, 2, 1);
        test.put(1, 4, 1);
        test.put(2, 3, 1);
        test.put(2, 5, 1);
        test.put(4, 5, 1);

        test.printGraph(1);

        for (int i = 1; i < test.size+1; i++) {   
            System.out.println(i+" : "+test.getVertex(i).toString());
        }
    }
    
    static class graphTest {

        public ArrayList<ArrayList<Node>> adList;
        public int size;
        
        graphTest(int init) {
            this.adList = new ArrayList<ArrayList<Node>>();
            this.size = init;
            for (int i = 0; i < init+1; i++) {
                this.adList.add(new ArrayList<Node>());
            }
        }

        void put(int vertex_x, int vertex_y, int weight) {
            this.adList.get(vertex_x).add(new Node(vertex_y, weight));
            this.adList.get(vertex_y).add(new Node(vertex_x, weight));
        }

        ArrayList<Node> getVertex(int idx) {
            return this.adList.get(idx);
        }

        void printGraph(int startIdx) {
            StringBuilder sb = new StringBuilder();

            for (int i = startIdx; i < this.size; i++) {
                sb.append(i + " : ");
                for (int j = 0; j < this.adList.get(i).size(); j++) {
                    sb.append(this.adList.get(i).get(j).getVertex()+" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
        
    }
    
    
    
    
    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        int getVertex() {
            return this.vertex;
        }

        int getWeight() {
            return this.weight;
        }
        @Override
        public String toString() {
            return Integer.toString(this.vertex);
        }
    }


    
 
}
