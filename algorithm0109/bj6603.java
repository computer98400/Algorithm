package algorithm0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj6603 {
    public static int[] number;

    public static StringBuilder sb;
    public static void combi( int idx, int count, int[] current) {
        if (count == 6) {
            for (int i = 0; i < current.length; i++) {
                sb.append(current[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = idx; i < number.length; i++) {
            current[count] = number[i];
            combi( i + 1, count + 1, current);
        }
    }
    
    
    public static void main(String[] args) throws IOException {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) {
                sb.setLength(sb.length()-2);
                System.out.println(sb);
                break;
            }
            number = new int[N];

            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }
            combi(0, 0, new int[6]);
            sb.append("\n");
        }

    }
}
