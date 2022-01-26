package algorithm0126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj3273 {
    
    
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        int start =0;
        int end =N-1;
        int hap = 0;
        int count = 0;
        Arrays.sort(numbers);
        while (start < end) {
            // System.out.println(end);
            hap = numbers[end]+ numbers[start];
            if (hap <= x) {
                start++;
            } else {
                end--;
            }

            if (hap == x) {
                count++;
            }
        }
        System.out.println(count);

    }


}