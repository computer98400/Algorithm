package algorithm1216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2447 {
    public static boolean[][] map;

    public static void divide(int x, int y, int size) { //size가 무엇인가
        
        if (size == 1) {
            map[x][y] = true;
            return;
        }
        int divideSize = size / 3;

        divide(x, y, divideSize);
        divide(x, y + divideSize, divideSize);
        divide(x, y + (divideSize * 2), divideSize);
        
        divide(x + divideSize, y, divideSize);
        //5번째 자리.
        divide(x + divideSize, y + (divideSize * 2), divideSize);
        
        divide(x + (divideSize * 2), y, divideSize);
        divide(x + (divideSize * 2), y + divideSize, divideSize);
        divide(x + (divideSize * 2), y + (divideSize * 2), divideSize);

    }

    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int size = Integer.parseInt(br.readLine());

        map = new boolean[size][size];

        divide(0, 0, size);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {

            for (int j = 0; j < map[0].length; j++) {

                if (map[i][j]) {

                    sb.append("*");

                } else {

                    sb.append(" ");

                }

            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}
