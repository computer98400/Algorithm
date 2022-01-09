package algorithm0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11660 {
    public static void main(String[] args) throws IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] hap = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < hap.length; i++) {
            hap[1][i] = hap[1][i-1]+map[0][i-1];
            hap[i][1] = hap[i-1][1]+map[i-1][0];
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
        }
        for (int i = 2; i < hap.length; i++) {
            for (int j = 2; j < hap.length; j++) {

                for (int k = 0; k < j; k++) {
                    hap[i][j] += hap[i][k];
                }
                hap[i][j] += map[i - 1][j];
            }
        }
        
        for (int i = 0; i < hap.length; i++) {
            System.out.println(Arrays.toString(hap[i]));
        }
    }
}
