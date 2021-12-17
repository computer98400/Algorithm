package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759 {
    
    public static char[] alpabat;
    public static StringBuilder sb;
    public static void combi(int idx, int count, int N,char[] numbers) {
        if (count == N) {
            int moTemp = 0;
            int jaTemp = 0;
            for (int i = 0; i < N; i++) {
                if (numbers[i] == 'a' || numbers[i] == 'e' || numbers[i] == 'i' || numbers[i] == 'o' || numbers[i] == 'u') {
                    moTemp++;
                } else {
                    jaTemp++;
                }
            }
            if (moTemp >= 1 && jaTemp >= 2) {
              //  sb.append("moTemp : " + moTemp + "jaTemp :" + jaTemp+" ");
                for (int i = 0; i < N; i++) {
                    sb.append(numbers[i]);
                }
                sb.append("\n");
                return;
            }
            return;
        }
        for (int i = idx; i < numbers.length; i++) {
            numbers[count] = alpabat[i];
            combi(i + 1, count + 1, N, numbers);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int L = Integer.parseInt(st.nextToken());
        
        int C = Integer.parseInt(st.nextToken());
        
        alpabat = new char[C];
        st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            alpabat[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(alpabat);
        
 //       System.out.println(Arrays.toString(alpabat));
        combi(0, 0, L, new char[C]);
        System.out.println(sb);
    }
}
