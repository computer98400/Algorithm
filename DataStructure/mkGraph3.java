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
        int trash = 0;
        mkGraph4 graph = new mkGraph4(V);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()," ");
            graph.addOneWay(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            trash = Integer.parseInt(st.nextToken());
        }
    }
}


class mkGraph4{
    ArrayList<ArrayList<Integer>> test;

    public mkGraph4(int size){
        test = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size+1; i++) {
            test.add(new ArrayList<>());   
        }
        System.out.println(test.toString());
    }

    public void addOneWay(int from, int to){
        test.get(from).add(to);
        System.out.println(from+"번째 정점에 "+to+"라는 값이 들어감");
        System.out.println(test.toString());
    }
    public void Show(int startNode){
        
    }
}
