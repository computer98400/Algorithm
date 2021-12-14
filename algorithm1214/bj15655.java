package algorithm1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15655 {
    public static int[] origin;
    
    public static void combi(int count,int[] numbers, int N , int idx) {
        if (count == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(numbers[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi(count + 1, numbers, N, i+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);

        combi(0, new int[N], M, 0);
    }
}
