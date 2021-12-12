package algorithm1212;

import java.util.Scanner;

public class bj1356 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String temp = sc.nextLine();
        boolean flag = true;
        int frontProduct = 1;
        int backProduct = 1;
        if (temp.length() == 1) {
            System.out.println("NO");
        } else {
            
        
        for (int i = 1; i < temp.length(); i++) {
            String front = temp.substring(0, i);
            String back = temp.substring(i, temp.length());
            frontProduct = 1;
            backProduct = 1;

          //  String frontTest = "";
          //  String backTest = "";
            
            for (int j = 0; j < front.length(); j++) {
                //frontTest += front.charAt(j) - '0' + "*";
                frontProduct *= front.charAt(j) - '0';
            }
         //   System.out.println(frontTest);
            for (int j = 0; j < back.length(); j++) {
               // backTest += back.charAt(j) - '0' + "*";
                backProduct *= back.charAt(j) - '0';
            }
          //  System.out.println(backTest);
          if (frontProduct == backProduct) {
              break;
           }
        }
        if (frontProduct == backProduct) {
            //   System.out.println(frontProduct);
               System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }


    }
}
