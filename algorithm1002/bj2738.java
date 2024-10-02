import java.io.*;
import java.util.StringTokenizer;
public class bj2738 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    StringTokenizer st2;

    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int[][] firstArr = new int[y][x];
    String sol = "";

    for (int i = 0; i < y; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for (int j =0; j < x; j++) {
        firstArr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i=0; i < y; i++) {
      st = new StringTokenizer(br.readLine()," ");

      for (int j=0; j <x; j++) {
        firstArr[i][j] += Integer.parseInt(st.nextToken());
        sol += firstArr[i][j];
        sol += " ";
      }
      sol += "\n";
    }
    
    System.out.println(sol);
  }
}