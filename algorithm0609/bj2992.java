package algorithm0609;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class bj2992 {
    public static int Len;
    public static int trans;
    public static ArrayList<Integer> test;
    public static ArrayList<Integer> answer;
    public static int min = Integer.MAX_VALUE;
    public static void combi(int idx, int count, int[] arr,boolean[] visited) {
        if (count == Len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }

            int temp = Integer.parseInt(sb.toString());
            if (temp > trans) {
                answer.add(temp);
            }
            return;
        }
        for (int i = 0; i < Len; i++) {
            if (visited[i])
                continue;
            arr[count] = test.get(i);
            visited[i] = true;
            combi(i + 1, count + 1, arr, visited);
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String N = sc.nextLine();
        sc.close();
        Len = N.length();
        // System.out.println(Len);
        trans = Integer.parseInt(N);
        test = new ArrayList<>();
        answer = new ArrayList<>();
        
        for (int i = 0; i < Len; i++) {
            test.add(N.charAt(i) - '0');
        }
        combi(0, 0, new int[Len], new boolean[Len]);
        if (answer.isEmpty()) {
            System.out.println(0);
        } else {
            Collections.sort(answer);
            System.out.println(answer.get(0));
        }
    }
}
