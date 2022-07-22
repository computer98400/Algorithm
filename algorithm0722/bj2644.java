import java.util.*;
public class MyClass {
    
    public static boolean[] visited;
    public static graph test;
    
    static class node {
        int count;
        int pos;
        node(int y,int x){
            this.count = y;
            this.pos = x;
        }
    }
    
    static class graph{
        ArrayList<ArrayList<Integer>> test;
        
        public graph(int size){
            test = new ArrayList<>();
            
            for(int i =0;i<size+1; i++){
                test.add(new ArrayList<Integer>());
            }
            
        }
        
        public void addVertex(){
            test.add(new ArrayList<Integer>());
        }
        
        public String showGraph(){
            return test.toString();
        }
        
        public void addTwoway(int y, int x){
            test.get(y).add(x);
            test.get(x).add(y);
        }
        public ArrayList getVertex(int pos){
            return test.get(pos);
        }
        public String showVertex(int pos){
            return test.get(pos).toString();
        }
    }
    public static boolean solution;
    
    public static void bfs(int start, int end){
        Queue<int[]> que = new LinkedList<>();
        visited[start] = true;
        que.add(new int[]{start,0});
        while(!que.isEmpty()){
            int[] pos = que.poll();
            // System.out.println(Arrays.toString(pos));
            if(pos[0] == end){
                System.out.println(pos[1]);
                solution = true;
                return;
            }
            ArrayList<Integer> temp2 = test.getVertex(pos[0]);

            
            for(int temp : temp2){
                if(visited[temp]) continue;
                
                visited[temp] = true;
                que.offer(new int[]{temp, pos[1]+1});
                
            }
            
            for(int i=0; i< temp2.size(); i++){
            // System.out.println(temp2.get(i)[0]);
            //     if(visited[temp2.get(i)[0]]) continue;
                
            //     visited[temp2.get(i)[0]] = true;
            //     que.offer(new int[]{temp2.get(i)[0], temp2.get(i)[1]+1});
            }
        }
    }
    
    public static void main(String args[]) {


    
      Scanner sc = new Scanner(System.in);
      
      int size = sc.nextInt();
      sc.nextLine();
      visited = new boolean[size+1];
      test  = new graph(size);
      
      int start = sc.nextInt();
      int end = sc.nextInt();
      
      sc.nextLine();
      
      int relation = sc.nextInt();
      sc.nextLine();
      for(int i =0; i< relation; i++){
          String[] temp = sc.nextLine().split(" ");
          
          test.addTwoway(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
          
      }
      
      
      bfs(start,end);
      if(!solution){
          System.out.println("-1");
      }
    }
}
