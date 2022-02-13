package algorithm0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bj2108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] numbers = new int[8001];
        int[] numbers3 = new int[8001];
        ArrayList<Integer> numbers2 = new ArrayList<>();
        int first = 0;
        for (int i = 0; i < N; i++) {
            int check = Integer.parseInt(br.readLine());
            numbers[check + 4000]++;
            numbers3[check + 4000]++;
            numbers2.add(check);
            first += check;
        }
        // System.out.println(9/5);
        double temp = (double)first / (double)N;
        // double temp2 = 9/5;
        System.out.println(Math.round(temp));
        numbers2.sort(null);
        System.out.println(numbers2.get(N / 2));
        Arrays.sort(numbers);
        ArrayList<Integer> numbers4 = new ArrayList<>();
        for (int i = 0; i < numbers3.length; i++) {
            if (numbers3[i] == numbers[numbers.length - 1]) {
                numbers4.add(i-4000);
            }
        }
        if (numbers4.size() == 1) {
            System.out.println(numbers4.get(0));
        } else {
            System.out.println(numbers4.get(1));
        }
        

        System.out.println(Math.abs(numbers2.get(0)-numbers2.get(numbers2.size()-1)));

    }
}
