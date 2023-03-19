package algorithm0124;

import java.util.ArrayList;

public class bj1062 {

  public static int K;
  public static int[] transNumbers;
  public static boolean[] existAlpa;
  public static ArrayList<Integer> input;
  public static int inputLength = 0;
  public static int solution = 0;

  public static void combi(int now,int pos, int numbers){

    if(now == K){
        solution = Math.max( solution , checkMax(numbers));
        return;
    }


    for(int i=pos; i< 26; i++){
        if(!existAlpa[i]) continue;
        numbers += transNumbers[i];
        combi(now+1,i+1, numbers);
        numbers -= transNumbers[i];

    }
    if(now > inputLength){
        combi(now+1,27, numbers);
    }

  }
  public static int checkMax(int combiResult){
      int count = 0;
      for(int i = 0; i< input.size(); i++){
          if((input.get(i) & ~combiResult) == 0){
              count++;
          }
      }

      return count;
  }
  
  
  public static void main(String[] args) {
    


  }
}
