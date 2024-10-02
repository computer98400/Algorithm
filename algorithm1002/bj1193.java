import java.io.*;
public class bj1193 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());
    int line = 1;
    int under = 0;
    int upper = 0;
 
    for (int i = 1; i < 4500; i++){
      if (target - i > 0) {
        target -= i;
      } else {
        line = i;
        break;
      }
    }
       
    if (line%2 == 0) {
      line += 1;
      under = line-target;
      upper = target;
    } else {
      line += 1;
      under = target;
      upper = line-target;
    }

    System.out.println(upper+"/"+under);
  }
}