package Algorithm.algorithm1227;

import java.util.ArrayList;
import java.util.Scanner;
public class sharkTest {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> test  = new ArrayList<>();

        test.add(1);
        test.add(1);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);
        test.add(2);

        int sharkSize = 2;
        int sharkCount = 0;
        int totalCount = 0;
        while(true){
            //System.out.println(test.get(0));
            if(test.isEmpty() || sharkSize < test.get(0)){
                System.out.println(test.toString());
                System.out.println(sharkSize+" "+sharkCount +" total : "+totalCount);
                break;
            }

            int temp = test.remove(0);

            if(temp < sharkSize){
                sharkCount++;
                totalCount++;
            }
            
            if(sharkCount == sharkSize){
                System.out.println("grow!");
                sharkSize++;
                sharkCount = 0;
            }
        }


    }
}
