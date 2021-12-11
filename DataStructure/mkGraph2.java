package Algorithm.DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

public class mkGraph2 {
    
    public static void main(String[] args) {
    
        madeG test = new madeG(5);


        int from;
        int to;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {  
             from = sc.nextInt();
             to = sc.nextInt(); 
            sc.nextLine();
            test.addOneWayNode(from, to);
        }


        test.showVertex(2);
        test.addOneWayNode(3,2);
        test.addTwoWayNode(2,4);
        test.showGraph();
    }
}

class madeG{
    ArrayList<ArrayList<Integer>> listGraph;
    
    public madeG(int size){
        listGraph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size+1; i++) {
                listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return listGraph;
    }

    public void addVertex(){
        listGraph.add(new ArrayList<Integer>());
    }
    public void addOneWayNode(int vertex, int node){
        listGraph.get(vertex).add(node);
        System.out.println(vertex+"번 정점에 "+ node + "추가되었습니다");
    }
    public void addTwoWayNode(int vertex, int node){
        listGraph.get(vertex).add(node);
        listGraph.get(node).add(vertex);
        System.out.println(vertex+"번 정점에 "+ node + "추가되었습니다");
        System.out.println(node+"번 정점에 "+ vertex + "추가되었습니다");
    }

    public String showVertex(int x){
        return listGraph.get(x).toString();
    }

    public void showGraph(){
        System.out.println(listGraph.toString());    
    }

}