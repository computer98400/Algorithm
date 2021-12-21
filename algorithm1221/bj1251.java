package algorithm1221;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj1251 {
    public static String test;
    public static ArrayList<String> temp;
    public static void combi(int count, int idx, int size, int[] numbers) {
        
        if (count == 2) {
            String first = test.substring(0, numbers[0]);
            String second = test.substring(numbers[0], numbers[1]) ;
            String third = test.substring(numbers[1], test.length());
            String first2 = "";
            String second2 = "";
            String third2 = "";
            for (int i = first.length()-1; i >= 0; i--) {
                first2 += first.charAt(i);
            }
         //   System.out.println("check"+first2);
            for (int i = second.length()-1; i >= 0 ; i--) {
                second2 += second.charAt(i);
            }
            
            for (int i = third.length()-1; i >= 0 ; i--) {
                third2 += third.charAt(i);
            }

            temp.add(first2 + second2 + third2);
//          System.out.println(first2+second2+third2);
            return ;
        }
        

        for (int i = idx; i < size; i++) {
            numbers[count] = i;
            combi(count + 1, i + 1,size, numbers);
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        test = sc.nextLine();
        temp = new ArrayList<>();
        combi(0, 0, test.length()-1, new int[test.length()]);
        Collections.sort(temp);
        // for (int i = 0; i < temp.size(); i++) {
        //     System.out.println(temp.get(i));
        // }
        System.out.println(temp.get(0));
    }
}
