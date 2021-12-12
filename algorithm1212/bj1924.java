package algorithm1212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj1924 {

    public static int[] dirY = {-1,-1,-1,0,0,1,1,1};
    public static int[] dirX = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[N][N];
        String[][] map2 = new String[N][N];
        ArrayList<int[]> mine = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < N; j++) {
                if (temp.charAt(j) != '.') {
                    int number = temp.charAt(j) - '0';
                    mine.add(new int[] { i, j });
                    for (int k = 0; k < dirY.length; k++) {
                        if (i + dirY[k] >= 0 && i + dirY[k] < N && j + dirX[k] >= 0 && j + dirX[k] < N) {
                            map[i + dirY[k]][j + dirX[k]] += number;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2.length; j++) {
                if (map[i][j] >= 10) {
                    map2[i][j] = "M";
                } else {
                    map2[i][j] = Integer.toString(map[i][j]);
                }
            }
        }
        for (int i = 0; i < mine.size(); i++) {
            map2[mine.get(i)[0]][mine.get(i)[1]] = "*";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2.length; j++) {
                sb.append(map2[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
        


    }
}
