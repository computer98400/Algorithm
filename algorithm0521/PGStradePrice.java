package Algorithm.algorithm0521;

import java.util.Arrays;
import java.util.Stack;

public class PGStradePrice {

    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer> test = new Stack<>();
        
        for(int i =0; i<prices.length; i++){
            if(test.isEmpty()){
                test.push(i);
            }else{
                // System.out.println(i+" prices 값 : "+prices[test.peek()] + " 현재 값 : "+prices[i]);
                if( prices[i] >= prices[test.peek()] ) {
                    // System.out.println("스택에 들어가는 값 : "+i);
                    test.push(i);
                }else{
                    while(prices[test.peek()] > prices[i]){
                        answer[test.peek()] = i-test.peek();
                        test.pop();
                        if(test.isEmpty()){
                            break;
                        }
                    }
                    test.push(i);    
                }
            }

        }
        while(!test.isEmpty()){
            answer[test.peek()] = prices.length-1 - test.peek();
            test.pop();
        }
        // System.out.println(Arrays.toString(answer));
        
        return answer;
    }
    public static void main(String[] args) {
       solution(new int[]{1,2,3,2,3});

    }
}
