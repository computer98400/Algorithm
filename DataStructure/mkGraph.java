package Algorithm.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class mkGraph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        graphLinkedList test = new graphLinkedList(N);
        sc.nextLine();

        for (int i = 0; i < N - 1; i++) {
            String[] temp = sc.nextLine().split(" ");
            test.addEdge(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }

        test.print();
        sc.close();
    }

}

class graphLinkedList {
    private ArrayList<ArrayList<Integer>> listGraph;

    public graphLinkedList(int size) {
        listGraph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < size + 1; i++) {
            listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph() {
        return listGraph;
    }

    public void addEdge(int x, int y) {
        // single way
        listGraph.get(x).add(y);
        // way
        // listGraph.get(y).add(x);
    }

    public void print() {
        for (int i = 1; i < listGraph.size(); i++) {
            System.out.print("현재 정점 : " + i + " -> ");
            for (int j = 0; j < listGraph.get(i).size(); j++) {
                System.out.print(listGraph.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public void follow(int start) {

    }
}