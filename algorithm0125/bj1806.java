package algorithm0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        long[] number = new long[N];
        st = new StringTokenizer(br.readLine()," ");
        number[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            number[i] = number[i - 1] + Integer.parseInt(st.nextToken());
        }



        
        System.out.println(Arrays.toString(number));

    }
}
