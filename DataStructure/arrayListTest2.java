package DataStructure;

import java.util.ArrayList;

public class arrayListTest2 {
    

    static class listDouble {
        ArrayList<ArrayList<edge>> test;
        int listSize;

        listDouble(int init) {
            this.test = new ArrayList<ArrayList<edge>>();
            this.listSize = init;

            for (int i = 0; i < init+1; i++) {
                this.test.add(new ArrayList<edge>());
            }
        }
        //무방향 그래프
        void put(int x, int y, int weight) {
            this.test.get(x).add(new edge(y, weight));
            this.test.get(y).add(new edge(x, weight));
        }
        //단방향 그래프
        void putSingle(int x, int y, int weight) {
            this.test.get(x).add(new edge(y, weight));
        }

        String printGraph(int start) {
            StringBuilder sb = new StringBuilder();

            for (int i = start; i < this.listSize + 1; i++) {
                sb.append(i + " : ");
                for (int j = 0; j < this.test.get(i).size(); j++) {
                    sb.append(this.test.get(i).get(j).vertex + " " + this.test.get(i).get(j).weight).append("\n");
                }
            }
            return sb.toString();
        }
    }

    static class edge {
        int vertex;
        int weight;

        edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        listDouble test = new listDouble(5);



        test.printGraph(1);


        
    }


}
