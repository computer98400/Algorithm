import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11052{

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    String temp = br.readLine();


    int size = Integer.parseInt(temp);

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] dp = new int[size];

    for(int i =0; i<size; i++){
      for(int j=0; j<=i; j++){
         dp[j] = Math.max(dp[i-j]+num[i],)
      }

    }

}


}