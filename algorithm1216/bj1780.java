package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1780 {
    public static int[][] map;
    public static int solutionZero = 0;
    public static int solutionOne = 0;
    public static int solutionMinus = 0;
    
    public static boolean check(int x, int y, int size) {
        int temp = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (temp != map[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }
    public static void divide(int x, int y, int size) {
        //사이즈와 갯수가 같다면

        if (check(x, y, size)) {
            if (map[x][y] == 1) {
                solutionOne++;
            } else if (map[x][y] == 0) {
                solutionZero++;
            }else if (map[x][y] == -1) {
                solutionMinus++;
            }
            return;
        }
        
     //   System.out.println("x : " + x + " y : " + y + " size : " + size);
        int divideSize = size / 3;

        divide(x, y, divideSize);
        
        divide(x, y + divideSize, divideSize);
        
        divide(x, y + (divideSize * 2), divideSize);
        
        divide(x + divideSize, y, divideSize);
        
        divide(x + divideSize, y + divideSize, divideSize);
        
        divide(x + divideSize, y + (divideSize * 2), divideSize);
        
        divide(x + (divideSize * 2), y, divideSize);
        
        divide(x + (divideSize * 2), y + divideSize, divideSize);
        
        divide(x + (divideSize * 2), y + (divideSize * 2), divideSize);
        
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, size);
        System.out.println(solutionMinus + "\n" + solutionZero + "\n" + solutionOne);

    }
}
