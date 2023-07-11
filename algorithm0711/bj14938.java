import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj14938 {

    public static ArrayList<graphInfo> graph;
    public static int[][] daikstra;
    public static int[] solution;
    static class node implements Comparable<node>{
        int destination;
        int distance;

        node(int destination, int distance){
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "["+this.destination+" "+this.distance+"]";
        }

        @Override
        public int compareTo(node o) {
            if(this.distance < o.distance){
                return -1;
            }
            return 1;
        }
    }

    static class graphInfo{
        int item;
        ArrayList<node> sub;

        graphInfo(int item){
            this.item = item;
            sub = new ArrayList<>();
        }

        void appendChannel(int to, int distance){
            this.sub.add(new node(to,distance));
        }

        @Override
        public String toString() {
            return "["+this.item+" "+this.sub.toString()+"]";
        }
    }
    public static int scan;
    public static void bfs(int start){
        PriorityQueue<node> que = new PriorityQueue<>();

        que.add(new node(start,0));
        daikstra[start][start] = 0;
        while(!que.isEmpty()){
            node temp = que.poll();
            for(node single : graph.get(temp.destination).sub){
                if(single.destination != start && daikstra[start][temp.destination] + single.distance <= scan &&  daikstra[start][temp.destination] + single.distance < daikstra[start][single.destination]){
                    que.offer(new node(single.destination,daikstra[start][temp.destination] + single.distance));
                    daikstra[start][single.destination] = daikstra[start][temp.destination] + single.distance;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        scan = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        solution = new int[n];
        daikstra = new int[n][n];
        for(int i=0; i<n; i++){
            graph.add(new graphInfo(Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());
            graph.get(from).appendChannel(to,distance);
            graph.get(to).appendChannel(from,distance);
        }
//        for(graphInfo temp : graph){
//            System.out.println(temp.toString());
//        }

        for(int[] temp : daikstra){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++){
            bfs(i);
        }
        int result = 0;

//        for(int i=0; i< daikstra.length; i++){
//            System.out.println(Arrays.toString(daikstra[i]));
//        }
        for(int temp=0; temp<solution.length; temp++){
            for(int i=0;i<n;i++){
                if(daikstra[temp][i] != Integer.MAX_VALUE){
                    solution[temp] += graph.get(i).item;
                }
            }
//            System.out.println(solution[temp]);
            result = Math.max(result, solution[temp]);
        }
        System.out.println(result);
    }
}
