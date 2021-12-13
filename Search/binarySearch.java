package Search;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    //public static int[]  numbers = new int[1000];

    public static int binary(int[] numbers,int searchN) {
        Arrays.sort(numbers);
        int left = 0;
        int right =  numbers.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (numbers[mid] == searchN) {
                return 1;
            }
            if (numbers[mid] < searchN) {
                left = mid + 1;
                
            } else if(numbers[mid]> searchN){
                right = mid - 1;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int searchN = sc.nextInt();
        int[]  numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println(binary(numbers,searchN));
        // int left = 0;
        // int right = numbers.length;
        // int count = 0;
        // while (left <= right) {
        //     int mid = (left+right)/2;
        //     System.out.println("left : "+left+" right : "+right+" mid : "+mid);
        //     if (searchN > numbers[mid]) {
        //         left = mid + 1;
        //     }else if(searchN < numbers[mid] ){
        //         right = mid - 1;
        //     } else {
        //         System.out.println("끝~! "+count+"번 탐색함");
        //         break;
        //     }
        //     count++;
        // }


    }
}
