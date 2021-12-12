package algorithm1212;

import java.util.Scanner;

public class bj1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] colors = new String[] {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
        int[] colorsProduct = new int[] {1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};

        String temp = sc.nextLine();
        String temp2 = sc.nextLine();
        String temp3 = sc.nextLine();
        long number1 = 0;
        long number2 = 0;
        long number3 = 0;

        for (int j = 0; j < colorsProduct.length; j++) {
            if (colors[j].equals(temp)) {
                number1 = j;
            }
            if (colors[j].equals(temp2)) {
                number2 = j;
            }
            if (colors[j].equals(temp3)) {
                number3 = colorsProduct[j];
            }
        }
        System.out.println((number1 * 10 + number2) * number3);
    }
}
