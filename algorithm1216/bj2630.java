package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2630 {
    public static int[][] map;
    public static int solutionBlue = 0;
    public static int solutionWhite = 0;

    
    public static void divide(int x, int y, int size) {
        if (colorCheck(x, y, size)) {
            if (map[x][y] == 1) {
                solutionBlue++;
            } else {
                solutionWhite++;
            }

            return;
        }
        int divideSize = size / 2;
        divide(x, y, divideSize);
        divide(x+divideSize, y, divideSize);
        divide(x, y+divideSize, divideSize);
        divide(x+divideSize, y+divideSize, divideSize);
    }
    
    public static boolean colorCheck(int x, int y, int size) {
        int temp = map[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (temp != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, N);
        System.out.println(solutionWhite + "\n" + solutionBlue);

    }
}
