package algorithm0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj5212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        

        char[][] map = new char[R][C];

        ArrayList<int[]> land = new ArrayList<>();
        ArrayList<int[]> change = new ArrayList<>();
        
        for (int i = 0; i < map.length; i++) {
            String temp = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                if (temp.charAt(j) == 'X') {
                    land.add(new int[] { i, j });
                }
                map[i][j] = temp.charAt(j);
            }
        }


        int[] dirY = { -1, 1, 0, 0 };
        int[] dirX = { 0, 0, -1, 1 };
        
        for (int i = 0; i < land.size(); i++) {
            int count = 0;
            for (int j = 0; j < dirX.length; j++) {
                if (land.get(i)[0] + dirY[j] < 0 || land.get(i)[1] + dirX[j] < 0 || land.get(i)[0] + dirY[j] == R
                        || land.get(i)[1] + dirX[j] == C
                        || map[land.get(i)[0] + dirY[j]][land.get(i)[1] + dirX[j]] == '.') {
                    count++;
                }

            }
            if (count >= 3) {
                change.add(land.get(i));
            }
        }

        for (int i = 0; i < change.size(); i++) {
            for (int j = 0; j < land.size(); j++) {
                if (change.get(i) == land.get(j)) {
                    land.remove(j);
                    continue;
                }
            }
        }
        for (int i = 0; i < change.size(); i++) {
            map[change.get(i)[0]][change.get(i)[1]] = '.';
        }

        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        //System.out.println(land.toString());
        for (int i = 0; i < land.size(); i++) {

            maxY = Math.max(land.get(i)[0], maxY);
            maxX = Math.max(land.get(i)[1], maxX);

            minY = Math.min(land.get(i)[0], minY);
            minX = Math.min(land.get(i)[1], minX);
        }
        //System.out.println(minY+" "+maxY+"   "+minX+" "+maxX);
        StringBuilder sb = new StringBuilder();
        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
