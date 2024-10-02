import java.io.*;
import java.util.StringTokenizer;

public class bj2566 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int maxValue = 0;
    int y = 0;
    int x = 0;
    
    for (int i=1; i<10; i++) {
      st = new StringTokenizer(br.readLine(), " ");

      for (int j=1; j<10; j++) {
        int temp = Integer.parseInt(st.nextToken());

        if (maxValue < temp) {
          maxValue = Math.max(maxValue, temp);
          y = i;
          x = j;
        }
      }
    }
    
    String sol = maxValue+" \n"+y+" "+x;
    System.out.println(sol);

  }
}