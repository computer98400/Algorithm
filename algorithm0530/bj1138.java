package algorithm0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1138 {

    public static int N;
    public static int[] numbers;

    public static void combi(int count, int[] test, boolean[] visited) {
        if (count == N) {
            System.out.println(Arrays.toString(test));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (visited[i])
                continue;
            test[count] = numbers[i];
            visited[i] = true;
            combi( count + 1, test, visited);
            visited[i] = false;
        }
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 1; i <= N; i++) {
            numbers[i - 1] = i;
        }
        
        System.out.println(Arrays.toString(numbers));
        System.out.println(N);
        combi( 0, new int[N], new boolean[N]);
    
    }

}