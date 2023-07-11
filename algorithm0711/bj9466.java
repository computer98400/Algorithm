import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj9466 {

    static ArrayList<ArrayList<Integer>> graph;

    static int[] visited;
    public static void dfs(int node, ArrayList<Integer> list){
        if(visited[node] == 2 && list.){
            for(int temp : list){
                visited[temp] = 2;
            }
            return;
        }

        if(visited[graph.get(node).get(0)] != 2 ){
            list.add(node);
            visited[graph.get(node).get(0)]++;
            dfs(graph.get(node).get(0), list);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int qq=0; qq< TC;qq++){
            int N = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            visited = new int[N];
            for(int i=0; i< N;i++){
                graph.add(new ArrayList<>());
            }

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i< N;i++){
                int temp = Integer.parseInt(st.nextToken())-1;
                graph.get(i).add(temp);
                if(temp == i){
                    visited[temp] = 2;
                }
            }
            for(int i=0; i< visited.length;i++){
                dfs(i,new ArrayList<>());
            }
            int solution = 0;
            for(int temp : visited){
                if(temp != 2) solution++;
            }
//            System.out.println(Arrays.toString(visited));
            System.out.println(solution);
        }
    }
}
