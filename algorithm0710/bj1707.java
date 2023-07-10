import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1707 {
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] colors;
    public static boolean[] visited;

    public static boolean bfs(int startNode){
        Queue<Integer> que = new LinkedList<>();
        que.add(startNode);
        colors[startNode] = 1;
        while(!que.isEmpty()){
            int start = que.poll();
            for(int i=0; i< graph.get(start).size(); i++){
                if(colors[graph.get(start).get(i)] == 0){
                    que.add(graph.get(start).get(i));
                    colors[graph.get(start).get(i)] = colors[start] == 1 ? -1 : 1;
                }else{
                    if(colors[start] == colors[graph.get(start).get(i)]){
                        return false;
                    }
                }
            }

        }
        return true;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i< TC;i++){
            st = new StringTokenizer(br.readLine()," ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            colors = new int[V];
            graph = new ArrayList<>();
            for(int j=0; j< V; j++){
                graph.add(new ArrayList<>());
            }

            for(int q=0;q<E;q++){
                st = new StringTokenizer(br.readLine()," ");
                int start = Integer.parseInt(st.nextToken())-1;
                int end = Integer.parseInt(st.nextToken())-1;
                graph.get(start).add(end);
                graph.get(end).add(start);
            }
//            for(int s=0; s<graph.size(); s++){
//                System.out.println("s : "+s+" "+graph.get(s).toString());
//            }

            boolean result = false;

            for(int r=0; r< colors.length; r++){
                if(colors[r] == 0){
                    if(bfs(r)){
                        result = true;
                    }else{
                        result = false;
                        break;
                    }
                }
            }

            if(result){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }



    }
}
