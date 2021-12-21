package algorithm1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11659 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] test = new int[N+1];
        int[] test2 = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            test[i] = Integer.parseInt(st.nextToken());
        }
        test2[0] = 0;
        for (int i = 1; i < test2.length; i++) {
                test2[i] = test2[i - 1] + test[i-1];
        }
   //     System.out.println(Arrays.toString(test2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());            
        //    System.out.println(test2[end - 1] + " " + test2[start - 1]);
            sb.append((test2[end]-test2[start-1])+"\n");
        }
        System.out.println(sb);
    }
}
