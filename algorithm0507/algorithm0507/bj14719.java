package algorithm0507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14719 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer size = new StringTokenizer(br.readLine(), " ");
    int height = Integer.parseInt(size.nextToken());
    int width = Integer.parseInt(size.nextToken());
    
    StringTokenizer eachHeight = new StringTokenizer(br.readLine(), " ");
    
    int[][] map = new int[height][width+2];

    for (int i = 0; i < height; i++) {
      map[i][0] = -999;
      map[i][width+1] = -999;
    }
    
    for (int i = 1; i < map[0].length-1; i++) {
      int each = Integer.parseInt(eachHeight.nextToken());
      for (int j = 0; j <each; j++) {
        map[map.length-1-j][i] = 1;
      }
    }

    int solution = 0;
    for (int i = 0; i < map.length; i++) {
      int count = 0;
      int start = 0;
      int isWall = 0;
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == 1 && start == 0) {
          start = j;
          continue;
        }


        if (start != 0 && map[i][j] == 1) {
          isWall = j;
          if (start == isWall || start+1 == isWall) {
            start = isWall;
            continue;
          }
          
          if (start != isWall && isWall !=0) {
            count += (isWall - start-1);
            start = isWall;
            continue;
          }
        }


        if (map[i][j] == -999) {
          start = 0;
          isWall = 0;
        }
      }
      solution += count;
    }

    System.out.println(solution);
  }


}
