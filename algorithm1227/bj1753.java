package Algorithm.algorithm1227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj1753{
    
    static class node{
        int child;
        int coin;

        node(int c, int coin){
            this.child = c;
            this.coin = coin;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int start =Integer.parseInt(br.readLine());

        ArrayList<ArrayList<node>> test = new ArrayList<>();
        
        for (int i = 0; i <= V; i++) {
            test.add(new ArrayList<node>());
        }
    }

}