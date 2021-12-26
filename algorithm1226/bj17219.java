package Algorithm.algorithm1226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,String> hash = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            hash.put(st.nextToken(),st.nextToken());
        }
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            sb.append(hash.get(temp)+"\n");
        }
        System.out.println(sb);
    }
}
