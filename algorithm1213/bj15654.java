package algorithm1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj15654 {
    public static int[] origin;
    
    public static void permu22(int count, int N, int[] numbers, boolean[] selected) {
        if (count == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(numbers[i] + " ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) continue;
            numbers[count] = origin[i];
            selected[i] = true;
            permu22(count + 1, N, numbers, selected);
            selected[i] = false;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        origin = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);
        permu22(0,M,new int[N],new boolean[N]);
    }
}
