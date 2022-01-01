package algorithm0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11403_notSolved {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][N];

        
        for (int i = 0; i < matrix.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < matrix.length; j++) {
                int temp = Integer.parseInt(st.nextToken());
                matrix[i][j] = temp;
            }
        }

        

    }
}
