package Algorithm.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mkGraph3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine());

        mkGraph4 graph = new mkGraph4(V);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            graph.addOneWay(Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken() ));
        }

    }
}


class mkGraph4{
    static ArrayList<ArrayList<node>> test;

    static class node {
        int end;
        int value;
     
        
        public node(int end, int value){
            this.end = end;
            this.value = value;
        }
        
    }
    public mkGraph4(int size){
        test = new ArrayList<ArrayList<node>>();
        for (int i = 0; i < size+1; i++) {
            test.add(new ArrayList<node>());   
        }
        System.out.println(test.toString());
    }

    public void addOneWay(int from, int to, int value){

        test.get(from).add(new node(to, value));

        System.out.println(from+"번째 정점에 "+test.get(from)+"라는 값이 들어감");
        
        System.out.println(test.toString());
        for (int i = 0; i < test.size(); i++) {
            for (node arrayList : test.get(i)) {
                System.out.print(arrayList.end+" "+arrayList.value);
            }
            System.out.println();
        }
    }
    public void Show(int startNode){
        
    }
}

// class nodeS{
//     int end;
//     int value;
 
    
//     public nodeS(int end, int value){
//         this.end = end;
//         this.value = value;
//     }
// }