import java.util.*;
public class bj2003 {
    public static void main(String args[]) {
      
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int M = sc.nextInt();
      sc.nextLine();
      String[] temp = sc.nextLine().split(" ");
      sc.close();
      int count=0;
      int[] numbers = new int[N];
      for(int i=0; i< temp.length; i++){
          numbers[i] = Integer.parseInt(temp[i]);
      }
      
      int start=0;
      int end = 0;
      while(start<N){
        int test=0;
        for(int i=start;i<end; i++){
            test+=numbers[i];
        }
        
         if(test >= M || end ==N){
             start++;
         }else{
             end++;
         }
          
          if(test == M){
              count++;
          }
      }
      System.out.println(count);
    }
}
