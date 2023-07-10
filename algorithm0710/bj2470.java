import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>();
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
        int left = 0;
        int right = numbers.size()-1;
        int solution = 1000000001;
        int leftValue = 0;
        int rightValue = 0;
        if(numbers.get(0) <0 && numbers.get(numbers.size()-1) < 0){
            System.out.println(numbers.get(numbers.size()-2)+" "+numbers.get(numbers.size()-1));
        }else if(numbers.get(0) >0 && numbers.get(numbers.size()-1) > 0){
            System.out.println(numbers.get(0)+" "+numbers.get(1));
        }else{
            while(left != right){
                if(Math.abs(numbers.get(left) + numbers.get(right)) < solution){
                    leftValue = numbers.get(left);
                    rightValue = numbers.get(right);
                    solution = Math.abs(numbers.get(left) + numbers.get(right));
                }

                if(Math.abs(numbers.get(left)) < Math.abs(numbers.get(right))){
                    right--;
                }else if(Math.abs(numbers.get(left)) == Math.abs(numbers.get(right))){
                    System.out.println(numbers.get(left)+" "+numbers.get(right));
                    return;
                }else{
                    left++;
                }
            }
        }
        System.out.println(leftValue+" "+rightValue);

    }

}
