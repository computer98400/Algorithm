import java.util.*;
public class bj1963 {
    public static int[] numbers;
    static class node{
        int number;
        int count;
        
        public node (int number, int count){
            this.number = number;
            this.count = count;
        }
    }

    public static void bfs(int input){
        Queue<node> que = new LinkedList<>();
        
        que.offer(new node(input,0));
        numbers[input]= 0;
        
        while(!que.isEmpty()){
            node pos = que.poll();
            String temp = Integer.toString(pos.number);
            for(int i=0; i<4; i++){
                int chg = temp.charAt(4%i)-'0';
                
                System.out.println(chg*Math.pow(10,i));
            }
            
            
            
        }
        
        
    }

    public static void main(String args[]) {
      
      
      ArrayList<Integer> test = new ArrayList<>();
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      numbers = new int[10000];
      
      for(int i=3; i< 9999; i+=2){
          numbers[i] =1;
      }
      
      for(int i=3;;i+=2){
          if(numbers[i]==1){
              int j = i*i;
              if(j>=9999) break;
              for(i*=2; j<9999; j+=i){
                  numbers[j] = 0;
              }
              i/=2;
          }
      }
      bfs(1033);
      
    }
}
