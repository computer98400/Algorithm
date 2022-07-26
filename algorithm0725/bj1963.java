import java.util.*;
public class bj1963 {
    public static boolean[] numbers;
    static class node{
        int number;
        int count;
        
        public node (int number, int count){
            this.number = number;
            this.count = count;
        }
    }

    public static void bfs(int input, int B){
        Queue<node> que = new LinkedList<>();
        
        que.offer(new node(input,0));
        if(numbers[input] == false || numbers[B] == false){
            System.out.println("Impossible");
            return;
        }
        numbers[input]= false;
        
        while(!que.isEmpty()){
            node pos = que.poll();
            String temp = Integer.toString(pos.number);
            
            if(pos.number == B){
                System.out.println(pos.count);
                return;
            }
            for(int i=0; i<4; i++){
                String before = temp.substring(0,i);
                int chg = temp.charAt(i)-'0';
                String after = temp.substring(i+1);
                char current = ' ';
                for( int j =0; j<10; j++){
                    if(i == 0 && j == 0) continue;
                    current = (char)(j+'0');
                    String test = before+current+after;
                    int result = Integer.parseInt(test);
                    if(numbers[result] == true){
                        que.offer(new node(result, pos.count+1));
                        numbers[result] = false;
                    }
                }
            }
        }    
    }
    
    public static void init(){
     numbers = new boolean[10000];
      
      for(int i=3; i< 9999; i+=2){
          numbers[i] =true;
      }
      
      for(int i=3;;i+=2){
          if(numbers[i]==true){
              int j = i*i;
              if(j>=9999) break;
              for(i*=2; j<9999; j+=i){
                  numbers[j] = false;
              }
              i/=2;
          }
      }
    }

    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      sc.nextLine();
      for( int i=0;i<N; i++){
          String[] temp = sc.nextLine().split(" ");
          init();
          bfs(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
          
      }
      
    }
}
