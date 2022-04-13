package algorithm0412;

import java.util.Arrays;

public class pssecretmap {


    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = "";
        }
        String[] temp1 = new String[n];
        String[] temp2 = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            temp1[i] = test(arr1[i],n);
        }
        
        for (int i = 0; i < arr2.length; i++) {
            temp2[i] = test(arr2[i],n);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp1[i].charAt(j) == temp2[i].charAt(j) && temp1[i].charAt(j) == '0') {
                    answer[i] += " ";
                } else {
                    answer[i] += '#';
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static String test(int n,int size) {
        return String.format("%0" + size + "d", Integer.parseInt(Integer.toBinaryString(n)));
    }


    //32 16 8 4 2 1
    //1  1  1 0 0 0
    //1  0  0 0 0 1
    public static void main(String[] args) {
        solution(6,new int[]{46, 33, 33 ,22, 31, 50},new int[]{27 ,56, 19, 14, 14, 10});
    }
}
