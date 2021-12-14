package algorithm1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (7) <-> 1<N<7 1<N<8
public class bj15656 {

    public static int[] origin;
    public static int M;

    public static void combi(int count, int[] numbers, int idx, StringBuilder sb) {
        if (count == M) {
            //이전 값이 더 클때 안함.
            for (int i = 1; i <  M; i++) {
                if (numbers[i - 1] > numbers[i]) {
                    return;
                }
            }
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = origin[i];
            combi(count + 1, numbers, idx, sb);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);
        StringBuilder sb = new StringBuilder();
        combi(0, new int[N], 0, sb);
        System.out.println(sb);
    }
}
