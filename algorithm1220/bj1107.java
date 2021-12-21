package algorithm1220;

import java.util.Arrays;
import java.util.Scanner;

public class bj1107 {
    
    public static int start;
    public static boolean[] numbers;


    public void checkTest(){
        System.out.println("check");
    }

    public static void vsTest(int number) {
        if (start - number > start) {
            System.out.println("check11");
        } else {
            System.out.println("check22");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = 100;
        int N = sc.nextInt();
        String temp = Integer.toString(N);
        int errorCount = sc.nextInt();
        numbers = new boolean[10];
        for (int i = 0; i < errorCount; i++) {
            numbers[sc.nextInt()] = true;
        }
        System.out.println(Arrays.toString(numbers));
        
        for (int i = 0; i < temp.length(); i++) {
            
        }

        vsTest(N);



        //기본값(100)에서 + 혹은 - 만을 누른 횟수 vs 각자리를 바꾼뒤에 --혹은++를 누른 횟수
        //초기값 x에서 +1 , -1, +2, -2등과 같이 점점 

    }
}
