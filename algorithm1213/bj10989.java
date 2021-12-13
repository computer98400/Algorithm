package algorithm1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10989 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[10000001];

        for (int i = 0; i < N; i++) {
            numbers[Integer.parseInt(br.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                for (int j = 0; j < numbers[i]; j++) {
                    sb.append(i + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
