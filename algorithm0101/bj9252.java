import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class bj9252{
  public static void main(String[] args)throws IOException{ 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String A = br.readLine();
    String B = br.readLine();

    int[][] dp = new int[B.length()+1][A.length()+1];
    for(int i =1;i<dp[0].length-1; i++){ 
      String bStart = ""+B.charAt(0);
      dp[1][i] = A.substring(0,i+1).contains(bStart) ? 1:0;
    }
    for(int i =1;i<dp.length-1; i++){ 
      String aStart = ""+A.charAt(0);
      dp[i][1] = B.substring(0,i+1).contains(aStart) ? 1:0;
    }

    for(int i=1; i < dp.length; i++){ 
      for(int j =1; j < dp[0].length; j++){ 
        if(B.charAt(i-1) == A.charAt(j-1)){ 
          dp[i][j] = dp[i-1][j-1]+1;
        }else{ 
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    //for(int[] temp: dp){ 
    //  System.out.println(Arrays.toString(temp));
    //}

    int y = dp.length-1;
    int x = dp[0].length-1;
    StringBuilder sb = new StringBuilder();
    while(true){ 
      if(x==0 || y==0){
        break;
      }
      if(dp[y-1][x] == dp[y][x]){
        y--; 
      }else if(dp[y][x] == dp[y][x-1]){ 
        x--;
      }else{ 
        //sb.append(A.charAt(x));
        y--;
        x--;
        sb.append(A.charAt(x));
      }
    }
    //for(int[] temp : dp){ 
    //  System.out.println(Arrays.toString(temp));
    //}
    System.out.println(dp[dp.length-1][dp[0].length-1]);
    System.out.println(sb.reverse().toString());
  }



}

