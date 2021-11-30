package Algorithm.DataStructure;

import java.util.ArrayList;

public class mkGraph2 {
    


    
    
    public static void main(String[] args) {
    
        madeG test = new madeG(5);
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

    public void addVertex(int x){
        listGraph.add(new ArrayList<Integer>(x));
    }

    public String showGraph(){
        return listGraph.toString();
    }
}