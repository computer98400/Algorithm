import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14500 {
  public static int[][] map;
  public static int solution;

  public static void longRect(){
    

    for(int i= 0; i< map.length; i++){
      for (int j = 0; j < map[0].length - 3; j++) {
        solution = Math.max(solution,(map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3]));
      }
    }

    for(int i= 0; i< map.length-3; i++){
      for (int j = 0; j < map[0].length; j++) {
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]));
      }
    }

  }

  public static void rectangle() {
    for (int i = 0; i < map.length-1; i++) {
      for(int j= 0; j < map.length-1; j++){ 
        solution = Math.max(solution,(map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1]));
      }
    }
  }

  public static void other() {
    for (int i = 0; i < map.length-2; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        // 3x2 
        solution = Math.max(solution,(map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i+2][j]));
        solution = Math.max(solution,(map[i][j] + map[i][j + 1] + map[i + 1][j+1] + map[i+2][j + 1]));
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i + 2][j] + map[i+2][j+1]));
        solution = Math.max(solution,(map[i][j+1] + map[i+1][j + 1] + map[i + 2][j] + map[i+2][j+1]));
        
        // ㄹ
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i + 1][j+1] + map[i+2][j + 1]));
        solution = Math.max(solution,(map[i][j+1] + map[i+1][j + 1] + map[i + 1][j] + map[i+2][j]));
        
        
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i + 2][j] + map[i+1][j + 1]));
        solution = Math.max(solution,(map[i+1][j] + map[i][j + 1] + map[i + 1][j+1] + map[i+2][j + 1]));
        
      }
    }



    for (int i = 0; i < map.length-1; i++) {
      for (int j = 0; j < map[0].length - 2; j++) {
        // 3x2 
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2]));
        solution = Math.max(solution,(map[i][j] + map[i+1][j] + map[i + 1][j+1] + map[i+1][j + 2]));
        solution = Math.max(solution,(map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2]));
        solution = Math.max(solution,(map[i+1][j] + map[i+1][j + 1] + map[i][j+2] + map[i+1][j+2]));
        
        // ㄹ
        solution = Math.max(solution,(map[i][j] + map[i][j+1] + map[i + 1][j+1] + map[i+1][j + 2]));
        solution = Math.max(solution,(map[i+1][j] + map[i+1][j + 1] + map[i][j+1] + map[i][j+2]));
        
        
        solution = Math.max(solution,(map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j + 1]));
        solution = Math.max(solution,(map[i][j+1] + map[i+1][j] + map[i + 1][j+1] + map[i+1][j + 2]));
        
      }
    }
  }

  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int R = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    solution = -9999;
    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < C; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int[] temp : map) {
      System.out.println(Arrays.toString(temp));
    }

    longRect();
    rectangle();
    other();
    System.out.println(solution);

  }
}
