package algorithm0130;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj1520 {
    static int[][] map;
    static int[][] dp;
    static int[] dirY = {-1,1,0,0};
    static int[] dirX = { 0, 0, -1, 1 };
    
    
    static int dfs(int y, int x) {
        
        if (dp[y][x] != -1)
            return dp[y][x];

        for (int i = 0; i < dirY.length; i++) {
            int tempy = y + dirY[i];
            int tempx = x + dirX[i];

            if (tempy >= 0 && tempx >= 0 && tempy < map.length && tempx < map[0].length
                    && map[y][x] > map[tempy][tempx]) {
                dp[y][x] = Math.max(dp[y][x], dfs(tempy,tempx));
            }
        }

        return dp[y][x];
    }

    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));





    }
}
